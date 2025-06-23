pipeline {
    agent any

    tools {
        maven 'Maven 3.9.10'
        jdk 'JDK 17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/alexanderMoellerOpitz/springdemo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -Dspring.profiles.active=test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'Build erfolgreich!'
        }
        failure {
            echo 'Build fehlgeschlagen.'
        }
    }
}
