def buildJar() {
    echo 'building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo 'building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
            docker.build("$USER/demo-app:jma-2.0", '.').push()
        }
    }
}

def deployApp() {
    echo 'deploying the application... xD'
}

return this
