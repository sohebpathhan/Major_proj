pipeline{
    stages{
        stage('code-pull'){
            steps{  
                git branch: 'main', url: 'https://github.com/sohebpathhan/Major_proj.git'
           }
        }
          stage('code-build'){
            steps{  
                sh '''
                cd flight-reservation-app-main/frontend
                npm install
                npm run build
                '''
           }
        }
          stage('code-deploy'){
            steps{  
                sh '''
                cd flight-reservation-app-main/frontend
                aws s3 sync dist/ s3://pro-frontend-project-bux/
                '''

           }
        }
    }
}