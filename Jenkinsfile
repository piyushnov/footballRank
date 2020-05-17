pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "mvn clean install -DskipTests"
                echo " done..."
            }
        }
        stage('Test') {
            steps {

            }
        }
        stage('Deploy') {
            steps {
                sh "java -jar $JENKINS_HOME/workspace/football_master/target/*.jar"
            }
        }
    }
}