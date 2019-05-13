// Tell Jenkins how to build projects from this repository
pipeline {
	agent {
		label 'magicdraw19'
	} 
	parameters {
		string(name: 'RELEASE_VERSION', defaultValue: '', 
			description: 'Set this parameter to the VIATRA version this V4MD build should include (e.g. 2.0.0.M3) and set the project version version accordingly. Leave it empty to skip this step.')
		string(name: 'INCUBATION_VERSION', defaultValue: '', 
			description: 'Set this parameter to the corresponding incubation version of the related VIATRA release.')
		string(name: 'PLUGIN_VERSION', defaultValue: '', 
			description: 'Set this parameter to the desired V4MD version.')
		string(name: 'BUILD_NUMBER', defaultValue: '', 
			description: 'Set this parameter to the desired MD internal version.')
	}
	// Keep only the last 5 builds
	options {
		buildDiscarder(logRotator(numToKeepStr: '5'))
	}
	environment {
		VERSION_STRINGS = "${params.PLUGIN_VERSION ? '-Pversion=' + params.PLUGIN_VERSION : ''} ${params.RELEASE_VERSION ? '-PviatraVersion=' + params.RELEASE_VERSION : ''} ${params.INCUBATION_VERSION ? '-PviatraIncubationVersion=' + params.INCUBATION_VERSION : ''} ${params.BUILD_NUMBER ? '-PbuildNumber=' + params.BUILD_NUMBER : ''}"
	}
	
	tools { 
		maven 'Maven 3.3.9' 
		jdk 'Oracle JDK 8' 
	}

	stages {
		stage('Build Plug-in') { 
			steps {
				dir ('com.incquerylabs.v4md'){
					sh "./gradlew clean"
					sh "./gradlew ${VERSION_STRINGS} assemble"
				}
			}
		}
		stage('Running Plug-in Tests') { 
			steps {
				dir ('com.incquerylabs.v4md'){
    				wrap([$class: 'Xvnc']) {
    					sh "./gradlew ${VERSION_STRINGS} runTest"
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
	                    		sh "./gradlew -PdeployUrl='https://build.incquerylabs.com/nexus/repository/v4md-snapshots/' ${VERSION_STRINGS} publish"
						    } else {			    
	                    		sh "./gradlew -PdeployUrl='https://build.incquerylabs.com/nexus/repository/v4md-releases/' ${VERSION_STRINGS} publish"
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
