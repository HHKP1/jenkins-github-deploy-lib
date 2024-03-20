def call(script, String dockerfileTemplate, String dockerImageName, String dockerImageTag, String nodeVersion, int containerPort) {
    def dockerBuildStage = new com.epam.pipeline.DockerBuildStage(script, dockerfileTemplate, dockerImageName, dockerImageTag, nodeVersion, containerPort)
    dockerBuildStage.run()
}