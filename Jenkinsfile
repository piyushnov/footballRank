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
                sh "cd $JENKINS_HOME/workspace/football_master/target/"
                sh "ls "
                sh "java -jar *.jar"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}