pipeline {
    agent {
        label 'MS Deploy Maven'
    }

    tools {
        maven 'Maven'
    }

    stages {
        stage('Verify Branch') {
            steps {
                echo "$GIT_BRANCH"
            }
        }
        stage('Run Echo') {
            steps {
                sh(script: 'echo Hello World')
            }
        }
        stage('Run Shell Script') {
            steps {
                sh(script: """
                    java -version
                    mvn --version
                """)
            }
        }
    }
}
