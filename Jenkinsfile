pipeline{
  agent 
  {
    docker{
     image 'maven:3-alpine'
        args '-v/.m2:/root/.m2'
  }
}
  

  stages {
    
    
    stage('MavenVersion'){
      steps{
         sh 'echo $JOB_NAME'
        sh 'echo $BUILD_NUMBER'
        echo 'Maven Vaersion'
        sh 'mvn -version'
       
      }
     }
    stage('Clean'){
      steps{
        echo 'Clean'
        sh 'mvn clean'
       
      }
     }
    stage('Compile'){
      steps{
        echo 'Compile'
        sh 'mvn compile'
        
      }
     }
    stage('package'){
      steps{
        echo 'Packing '
        sh 'mvn -B -DskipTests clean package'
        
      }
     }
    stage('Test'){
      steps{
        echo 'Maven test'
        sh 'mvn test'
      }
      
  }
    
    stage('SonarQube analysis') {
    def scannerHome = tool 'SonarScanner 4.0';
    withSonarQubeEnv('My SonarQube Server') { // If you have configured more than one global server connection, you can specify its name
      sh "${scannerHome}/bin/sonar-scanner"
    }
  }
  }
}
