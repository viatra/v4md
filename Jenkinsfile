// Tell Jenkins how to build projects from this repository
pipeline {
	agent {
		label 'ecs-md-slave'
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
	}
}
