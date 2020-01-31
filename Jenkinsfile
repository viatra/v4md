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
		TEAMS_NOTIFICATION_URL = credentials('v4md-teams-channel-url')
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
                    			sh "./gradlew ${VERSION_STRINGS} publish"
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
            office365ConnectorSend message: "Build Successful - ${env.JOB_NAME} <${env.BUILD_URL}>", 
				status:"Success",
				color: "00db00",
				webhookUrl:"${TEAMS_NOTIFICATION_URL}"
        }
        unstable {
            office365ConnectorSend message: "Build Unstable - ${env.JOB_NAME} <${env.BUILD_URL}>", 
				status:"Unstable", 
				color: "fcb019",
				webhookUrl:"${TEAMS_NOTIFICATION_URL}"
        }
        failure {
            office365ConnectorSend message: "Build Failed - ${env.JOB_NAME} <${env.BUILD_URL}>", 
				status:"Failure",
				color: "f21607",
				webhookUrl:"${TEAMS_NOTIFICATION_URL}"
        }
	}
}
