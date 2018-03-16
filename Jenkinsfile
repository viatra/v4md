// Tell Jenkins how to build projects from this repository
pipeline {
	agent {
		label 'magicdraw19'
	} 
	parameters {
		string(name: 'RELEASE_VERSION', defaultValue: '', 
			description: 'Set this parameter to a valid Maven version (e.g. 2.0.0.M3) to execute a set-version step before the build itself.')
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
		stage('Setting Release Version') {
			when {
				expression {params.RELEASE_VERSION != ''}
			} 
			steps {
				configFileProvider([configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
						sh "mvn versions:set -B -Dmd.home=${MD19_HOME} -s ${MAVEN_SETTINGS} -Dmaven.repo.local=${WORKSPACE}/.repository -DnewVersion=${params.RELEASE_VERSION}"	                          
                 }
			}
		}	
		stage('Build Plug-in') { 
			steps {
				configFileProvider([configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
					sh 'mvn clean install -B -Dmd.home=$MD19_HOME -s $MAVEN_SETTINGS -Dmaven.repo.local=$WORKSPACE/.repository'
				}
			}
		}
		stage('Maven Deploy') {
			when {branch "master"} 
			steps {
				configFileProvider([configFile(fileId: 'default-maven-settings', variable: 'MAVEN_SETTINGS')]) {
						sh 'mvn clean deploy  -B -Dmd.home=$MD19_HOME -s $MAVEN_SETTINGS -Dmaven.repo.local=$WORKSPACE/.repository'		                          
                 }
			}
		}
	}

	post {
		always {
			archiveArtifacts artifacts: 'com.incquerylabs.v4md/target/*.zip', onlyIfSuccessful: true
		}
	}
}