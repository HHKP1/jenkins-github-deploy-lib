def call(String dockerImageName, String dockerImageTag, String containerName, int containerPort) {
    def deployStage = new com.epam.pipeline.DeployStage(this, dockerImageName, dockerImageTag, containerName, containerPort)
    deployStage.run()
}