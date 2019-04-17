// Tell Jenkins how to build projects from this repository
pipeline {
	agent {
		label 'magicdraw19'
	} 
	parameters {
		string(name: 'RELEASE_VERSION', defaultValue: '2.1.2', 
			description: 'Set this parameter to the VIATRA version this V4MD build should include (e.g. 2.0.0.M3) and set the project version version accordingly. Leave it empty to skip this step.')
		string(name: 'INCUBATION_VERSION', defaultValue: '0.21.2', 
			description: 'Set this parameter to the corresponding incubation version of the related VIATRA release.')
		string(name: 'PLUGIN_VERSION', defaultValue: '2.1.3-SNAPSHOT', 
			description: 'Set this parameter to the desired V4MD version.')
		string(name: 'BUILD_NUMBER', defaultValue: '213010', 
			description: 'Set this parameter to the desired MD internal version.')
	}
	// Keep only the last 5 builds
	options {
		buildDiscarder(logRotator(numToKeepStr: '5'))
	}
	
	tools { 
		maven 'Maven 3.3.9' 
		jdk 'Oracle JDK 8' 
	}

	stages {
		stage('Build Plug-in') { 
			steps {
				dir ('com.incquerylabs.v4md'){
					sh "rm -rf build/dependency-cache"
					sh "./gradlew -Pversion=${params.PLUGIN_VERSION} -PviatraVersion=${params.RELEASE_VERSION} -PviatraIncubationVersion=${params.INCUBATION_VERSION} -PbuildNumber=${params.BUILD_NUMBER} clean"
					sh "./gradlew -Pversion=${params.PLUGIN_VERSION} -PviatraVersion=${params.RELEASE_VERSION} -PviatraIncubationVersion=${params.INCUBATION_VERSION} -PbuildNumber=${params.BUILD_NUMBER} assemble"
				}
			}
		}
		stage('Running Plug-in Tests') { 
			steps {
				dir ('com.incquerylabs.v4md'){
    				wrap([$class: 'Xvnc']) {
    					sh "./gradlew -Pversion=${params.PLUGIN_VERSION} -PviatraVersion=${params.RELEASE_VERSION} -PviatraIncubationVersion=${params.INCUBATION_VERSION} -PbuildNumber=${params.BUILD_NUMBER} runTest"
    				}
				}
			}
		}
		stage('Deploy Plugin') {
			when {branch "master"} 
			steps {
				withCredentials([usernamePassword(credentialsId: 'nexus-buildserver-deploy', passwordVariable: 'DEPLOY_PASSWORD', usernameVariable: 'DEPLOY_USER')]) {
					script{
					    dir ('com.incquerylabs.v4md') {
						    if (params.PLUGIN_VERSION.endsWith('-SNAPSHOT')) {
	                    		sh "./gradlew -PdeployUrl='https://build.incquerylabs.com/nexus/repository/v4md-snapshots/' publish"
						    } else {			    
	                    		sh "./gradlew -PdeployUrl='https://build.incquerylabs.com/nexus/repository/v4md-releases/' -Pversion=${params.PLUGIN_VERSION} -PviatraVersion=${params.RELEASE_VERSION} -PviatraIncubationVersion=${params.INCUBATION_VERSION} -PbuildNumber=${params.BUILD_NUMBER} publish"
	                    	}                          
					    }
					}
				}
			}
		}
	}

	post {
		always {
			archiveArtifacts artifacts: 'com.incquerylabs.v4md/build/distributions/*.zip', onlyIfSuccessful: true
			junit testResults: 'com.incquerylabs.v4md/build/install/target/*.xml'
		}
	}
}
