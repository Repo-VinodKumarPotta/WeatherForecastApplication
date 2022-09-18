pipeline {
    agent any

    stages {
        stage('Verify Branch') {
            steps {
                echo "$GIT_BRANCH"
            }
        }
        stage('Run Shell Script') {
            steps {
                sh(script: 'echo Hello World')
            }
        }
        stage('Run Shell Script') {
            steps {
                sh(script: """
                    mvn clean
                    mvn install
                    mvn package -u
                """)
            }
        }
    }
}
