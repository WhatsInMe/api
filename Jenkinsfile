pipeline {
    agent any

    stages {
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
