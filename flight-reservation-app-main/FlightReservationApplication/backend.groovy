pipeline{
    agent any

    stages{

        stage('code-pull'){
            steps{
                git branch: 'main', url: 'https://github.com/sohebpathhan/Major_proj.git'
            }
        }

        stage('code-Build'){
            steps{
                sh '''
                cd flight-reservation-app-main/FlightReservationApplication
                mvn clean package
                '''
            }
        }

        stage('QA_Test'){
            steps{
                withSonarQubeEnv(installationName: 'Sonar', credentialsId: 'Sonar_cred') {
                    sh '''
                    cd flight-reservation-app-main/FlightReservationApplication
                    mvn sonar:sonar -Dsonar.projectKey=flight-reservation
                    '''
                }
            }
        }

        stage('Docker-Build'){
            steps{
                sh '''
                cd flight-reservation-app-main/FlightReservationApplication
                docker build -t sohebpathhan/flight_resor:latest .
                docker push sohebpathhan/flight_resor:latest
                docker rmi sohebpathhan/flight_resor:latest
                '''
            }
        }

        stage('Deploy_stage'){
            steps{
                sh '''
                cd flight-reservation-app-main/FlightReservationApplication
                kubectl apply -f k8s/
                '''
            }
        }

    }
}
