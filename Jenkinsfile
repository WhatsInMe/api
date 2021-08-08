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

        // stage('Test') {
        //     steps {
        //         echo 'Testing..'
        //     }
        // }

        // stage('Deploy') {
        //     steps {
        //         echo 'Deploying....'
        //         sh ''
        //     }
        // }
    }
}
