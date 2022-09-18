pipeline {
    agent any

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
                    export MAVEN_HOME=/Volumes/VinodKumarPotta/Softwares/apache-maven-3.6.3
                    export PATH=$PATH:$MAVEN_HOME/bin
                    mvn --version
                    mvn clean install
                """)
            }
        }
    }
}
