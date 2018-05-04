// Tell Jenkins how to build projects from this repository
pipeline {
	agent {
		label 'magicdraw19'
	} 
	parameters {
		string(name: 'RELEASE_VERSION', defaultValue: '2.0.0-SNAPSHOT', 
			description: 'Set this parameter to the VIATRA version this V4MD build should include (e.g. 2.0.0.M3) and set the project version version accordingly. Leave it empty to skip this step.')
			string(name: 'INCUBATION_VERSION', defaultValue: '0.20.0-SNAPSHOT', 
			description: 'Set this parameter to the corresponding incubation version of the related VIATRA release.')
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
					sh "./gradlew clean build -PviatraVersion=${params.RELEASE_VERSION} -PviatraIncubationVersion=${params.INCUBATION_VERSION}" 					                                  
				}


			}
		}
		stage('Deploy Plugin') {
			when {branch "master"} 
			steps {
				withCredentials([usernamePassword(credentialsId: 'nexus-buildserver-deploy', passwordVariable: 'DEPLOY_PASSWORD', usernameVariable: 'DEPLOY_USER')]) {
					script{
					    dir ('com.incquerylabs.v4md') {
						    if (params.RELEASE_VERSION.endsWith('-SNAPSHOT')) {
	                    		sh "./gradlew publish -PdeployUrl='https://build.incquerylabs.com/nexus/repository/v4md-snapshots/' "
						    } else {			    
	                    		sh "./gradlew publish -PdeployUrl='https://build.incquerylabs.com/nexus/repository/v4md-releases/' "
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
		}
	}
}
