def call(String username = 'null', String designation = 'null') {
	echo "This is shared library sendoffUser: ${username}"
	pipeline {
		environment {
			USER_NAME = "$username"
			DESG = "${designation}"
		}
		agent any 
		stages {
			stage('SENDOF_USER') {
				steps {
					echo "hi $USER_NAME, Nice meeting you !"
					echo "my Designation: $DESG"
				}	
			}
		}
	}
}
