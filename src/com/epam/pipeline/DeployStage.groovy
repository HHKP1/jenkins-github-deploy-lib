package com.epam.pipeline

class DeployStage implements Serializable {
    def script
    String registry
    String dockerImageName
    String dockerImageTag
    String containerName
    int hostPort
    int containerPort

    DeployStage(script, String registry, String dockerImageName, String dockerImageTag, String containerName, int hostPort, int containerPort) {
        this.script = script
        this.registry = registry
        this.dockerImageName = dockerImageName
        this.dockerImageTag = dockerImageTag
        this.containerName = containerName
        this.hostPort = hostPort
        this.containerPort = containerPort
    }

    def run() {
        script.sh "docker run -d --expose ${containerPort} -p ${hostPort}:${containerPort} -v ~/.npm:~/.npm --name ${containerName} ${registry}/${dockerImageName}:${dockerImageTag}"
    }
}