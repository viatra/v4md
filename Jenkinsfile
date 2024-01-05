// Tell Jenkins how to build projects from this repository
pipeline {
	agent {
		label 'magicdraw-0'
	} 
	parameters {
		string(name: 'RELEASE_VERSION', defaultValue: '', 
			description: 'Set this parameter to update the project version version accordingly, should be used to remove -SNAPSHOT from version numbers. Leave it empty to keep version from the repository.')
	}
	// Keep only the last 5 builds
	options {
		buildDiscarder(logRotator(numToKeepStr: '5'))
	}
	environment {
		VERSION_STRINGS = " ${params.RELEASE_VERSION ? '-Pversion=' + params.RELEASE_VERSION : ''} "
		TEAMS_NOTIFICATION_URL = credentials('v4md-teams-channel-url')
	}
	tools { 	
		maven 'Maven 3.3.9' 	
		jdk 'AdoptOpenJDK 17' 	
	}
	stages {
		stage('Build Plug-in') { 
			steps {
				withCredentials([usernamePassword(credentialsId: 'nexus-buildserver-deploy', passwordVariable: 'DEPLOY_PASSWORD', usernameVariable: 'DEPLOY_USER')]) {
					dir ('com.incquerylabs.v4md'){
						sh './gradlew clean'
						sh './gradlew ${VERSION_STRINGS} assemble'
					}
				}
			}
		}
		stage('Running Plug-in Tests') { 
			steps {
				withCredentials([usernamePassword(credentialsId: 'nexus-buildserver-deploy', passwordVariable: 'DEPLOY_PASSWORD', usernameVariable: 'DEPLOY_USER')]) {
					dir ('com.incquerylabs.v4md'){
	    			    wrap([$class: 'Xvnc']) {
	    					sh './gradlew ${VERSION_STRINGS} runTest'
	    			    }
					}
				}
			}
		}
		stage('Deploy Plugin') {
			when {branch "2022x"} 
			steps {
				withCredentials([usernamePassword(credentialsId: 'nexus-buildserver-deploy', passwordVariable: 'DEPLOY_PASSWORD', usernameVariable: 'DEPLOY_USER')]) {
					script{
					    dir ('com.incquerylabs.v4md') {
                    			        sh './gradlew ${VERSION_STRINGS} publish'
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
		
		success {
            		office365ConnectorSend status: "Success",
				color: "00db00",
				webhookUrl: '${TEAMS_NOTIFICATION_URL}'
        	}
        	unstable {
            		office365ConnectorSend status: "Unstable",
				color: "fcb019",
				webhookUrl: '${TEAMS_NOTIFICATION_URL}'
        	}
        	failure {
            		office365ConnectorSend status: "Failure",
				color: "f21607",
				webhookUrl: '${TEAMS_NOTIFICATION_URL}'
        	}
	}
}
