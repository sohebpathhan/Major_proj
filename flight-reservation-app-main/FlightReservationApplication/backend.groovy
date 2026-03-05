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
                cd flight-reservation-app-main\FlightReservationApplication
                mvn clean package
                '''
            }
        }
    }
}