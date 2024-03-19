def call(script, String registry, String containerName, String dockerfileTemplate, String dockerImageName, String dockerImageTag, String nodeVersion, int containerPort) {
    def dockerBuildStage = new com.epam.pipeline.DockerBuildStage(script, registry, containerName, dockerfileTemplate, dockerImageName, dockerImageTag, nodeVersion, containerPort)
    dockerBuildStage.run()
}