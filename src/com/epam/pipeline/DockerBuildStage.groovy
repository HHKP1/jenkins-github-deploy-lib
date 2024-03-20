package com.epam.pipeline

class DockerBuildStage implements Serializable {
    def script
    def utils
    String dockerfileTemplate
    String dockerImageName
    String dockerImageTag
    String nodeVersion
    int containerPort

    DockerBuildStage(script, String registry, String dockerfileTemplate, String dockerImageName, String dockerImageTag, String nodeVersion, int containerPort) {
        this.script = script
        this.utils = new Utils(script)
        this.registry = registry
        this.dockerfileTemplate = dockerfileTemplate
        this.dockerImageName = dockerImageName
        this.dockerImageTag = dockerImageTag
        this.nodeVersion = nodeVersion
        this.containerPort = containerPort
    }

    def run() {
        script.withCredentials([script.string(credentialsId: 'docker-access-token', variable: 'DOCKER_ACCESS_TOKEN')]) {
            utils.printMessage('Building the Docker image...')
            script.sh "echo ${script.DOCKER_ACCESS_TOKEN} | docker login --username hhkp --password-stdin"

            def dockerfileContent = script.libraryResource("com/epam/pipeline/templates/${dockerfileTemplate}")
            utils.printMessage("Dockerfile content resource path: ${dockerfileContent}")
            dockerfileContent = dockerfileContent.replace('${NODE_VERSION}', nodeVersion)
            dockerfileContent = dockerfileContent.replace('${CONTAINER_PORT}', containerPort.toString())

            script.writeFile file: 'Dockerfile', text: dockerfileContent

            script.sh "docker build -t ${dockerImageName}:${dockerImageTag} ."
            script.sh "docker push ${registry}/${dockerImageName}:${dockerImageTag}"
        }
    }
}