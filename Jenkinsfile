pipeline{
  agent 
  {
    docker{
     image 'maven:3-alpine'
        args '-v/.m2:/root/.m2'
  }
}
  

  stages {
    
    
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
   
    
    stage('build && SonarQube analysis') {
            steps {
             sh 'mvn verify sonar:sonar'
            }
    }
  }
}
