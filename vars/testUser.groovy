def call(String username = 'null') {
	echo "This is shared library greetUser: ${username}"
	pipeline {
	agent any
	parameters {
		choice(name: 'TARGET_ENV', choices: ['test', 'prod'], description: 'Target environment to deploy')
	}	
	environment {
		DEPLOY_TO = "${TARGET_ENV}"
	}	
	stages {
		stage('DEPLOY_TEST') {
			when {
				environment name: 'DEPLOY_TO', value: 'test'
			}	
			steps {
				echo "DEPLOY TO TEST ENVIRONMENT ......."
				sh 'sleep 5'
			}		
		}
		stage('DEPLOY_PROD') {
			when {
				environment name: 'DEPLOY_TO', value: 'prod'
			}	
			steps {
				echo ""
				echo "DEPLOY TO PRODUCTION ......."
				sh 'sleep 5'
				sh 'exit 1'
			}		
		}

	}	
	
			post {
			failure {
			 echo "You can always see me."
			}
			
			
		}
}
}
