pipeline {
    agent any

    stages {
        stage('Verify Branch') {
            steps {
                echo "$GIT_BRANCH"
            }
        }
        stage('Run Shell Script'){
            steps {
                step {
                    echo "Hello"
                }
                step {
                    sh(script: 'echo Hello World')
                }
            }
        }
    }
}
