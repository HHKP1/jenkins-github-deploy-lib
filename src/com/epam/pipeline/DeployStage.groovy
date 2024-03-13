package com.myorg.pipeline

class DeployStage implements Serializable {
    def script
    String dockerImageName
    String dockerImageTag
    String containerName
    int containerPort

    DeployStage(script, String dockerImageName, String dockerImageTag, String containerName, int containerPort) {
        this.script = script
        this.dockerImageName = dockerImageName
        this.dockerImageTag = dockerImageTag
        this.containerName = containerName
        this.containerPort = containerPort
    }

    def run() {
        script.sh "docker stop ${containerName} || true"
        script.sh "docker rm ${containerName} || true"
        script.sh "docker run -d --expose ${containerPort} -p ${containerPort}:${containerPort} --name ${containerName} ${dockerImageName}:${dockerImageTag}"
    }
}