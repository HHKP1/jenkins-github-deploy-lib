package com.epam.pipeline

class DockerBuildStage implements Serializable {
    def script
    String dockerfileTemplate
    String dockerImageName
    String dockerImageTag
    String nodeVersion
    int containerPort

    DockerBuildStage(script, String dockerfileTemplate, String dockerImageName, String dockerImageTag, String nodeVersion, int containerPort) {
        this.script = script
        this.dockerfileTemplate = dockerfileTemplate
        this.dockerImageName = dockerImageName
        this.dockerImageTag = dockerImageTag
        this.nodeVersion = nodeVersion
        this.containerPort = containerPort
    }

    def run() {
        script.withCredentials([script.string(credentialsId: 'docker-access-token', variable: 'DOCKER_ACCESS_TOKEN')]) {
            script.sh "echo ${script.DOCKER_ACCESS_TOKEN} | docker login --username hhkp --password-stdin"

            def dockerfileContent = script.libraryResource(dockerfileTemplate)
            dockerfileContent = dockerfileContent.replace('${NODE_VERSION}', nodeVersion)
            dockerfileContent = dockerfileContent.replace('${CONTAINER_PORT}', containerPort.toString())

            script.writeFile file: 'Dockerfile', text: dockerfileContent

            script.sh """
		docker build \
			--cache-from ${dockerImageName}:${dockerImageTag} \
			--build-arg BUILDKIT_INLINE_CACHE=1 \
			-t ${dockerImageName}:${dockerImageTag} .
	    """
            script.sh "docker push ${dockerImageName}:${dockerImageTag}"
        }
    }
}
