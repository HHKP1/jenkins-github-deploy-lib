def call(script, String registry, String containerName, String dockerImageName, String dockerImageTag) {
    def dockerBuildStage = new com.epam.pipeline.DockerBuildStage(script, registry, containerName, dockerImageName, dockerImageTag)
    dockerBuildStage.run()
}