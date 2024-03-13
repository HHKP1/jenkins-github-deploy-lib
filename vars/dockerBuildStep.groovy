def call(String dockerfileTemplate, String dockerImageName, String dockerImageTag, String nodeVersion, int containerPort) {
    def dockerBuildStage = new com.myorg.pipeline.DockerBuildStage(this, dockerfileTemplate, dockerImageName, dockerImageTag, nodeVersion, containerPort)
    dockerBuildStage.run()
}