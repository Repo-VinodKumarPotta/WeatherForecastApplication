pipeline {
    agent any

    stages {
        stage('Verify Branch') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Good Bye') {
            steps {
                echo "$GIT_BRANCH"
            }
        }
    }
}
