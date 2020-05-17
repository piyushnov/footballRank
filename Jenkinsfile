pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "mvn clean install -DskipTests"
            }
        }
        stage('Test') {
            steps {
                echo "testing started..."
                sh "mvn test"
                echo "testing done...."
            }
        }
        stage('Deploy') {
            steps {
                sh "java -jar $JENKINS_HOME/workspace/football_master/target/*.jar"
            }
        }
    }
}