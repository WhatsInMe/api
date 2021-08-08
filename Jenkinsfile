pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Build') {
            steps {
                sh 'docker build -t yw/whatsinme-api .'
            }
        }

        stage('Deploy') {
            steps {
                build 'whatsinme-compose'
            }
        }
    }
}
