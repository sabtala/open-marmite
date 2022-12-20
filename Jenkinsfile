pipeline{
    agent any
    tools {
            maven 'M2_HOME'
    }

    environment {
    registry = '676567995387.dkr.ecr.us-east-1.amazonaws.com/jenkins'
    registryCredential = 'aws_ecr_id'
    dockerimage = ''
    }
    
    stages{
        stage("maven builder"){
            steps{
                sh 'mvn clean install package'
            }
        }

        stage("upload artifact"){
            steps{
                script{
                def mavenPom = readMavenPom file: 'pom.xml'
                nexusArtifactUploader artifacts: 
                [[artifactId: "${mavenPom.artifactId}",
                 classifier: '',
                  file: "target/${mavenPom.artifactId}-${mavenPom.version}.${mavenPom.packaging}",
                   type: "${mavenPom.packaging}"]],
                    credentialsId: 'NexusID',
                     groupId: "${mavenPom.groupId}",
                      nexusUrl: '157.230.180.228:8081',
                       nexusVersion: 'nexus3',
                        protocol: 'http',
                         repository: 'openmarmite',
                          version: "${mavenPom.version}"
                }
            }
        }

        stage('Build Image') {
            
            steps {
                script{
                  def mavenPom = readMavenPom file: 'pom.xml'
                    dockerImage = docker.build registry + ":${mavenPom.version}"
                } 
            }
        }
        stage('Deploy image') {
           
            
            steps{
                script{ 
                    docker.withRegistry("https://"+registry,"ecr:us-east-1:"+registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        } 
    }
    

}