pipeline {
    agent any

    tools {
        maven 'Maven 3.9.10' // Name muss in Jenkins unter "Global Tool Configuration" definiert sein
        jdk 'JDK 17'        // Oder deine installierte JDK-Version
    }

//     environment {}

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/alexanderMoellerOpitz/springdemo.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean compile'
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
