def call(String dockerImageName, String dockerImageTag, String containerName, int containerPort) {
    def deployStage = new com.myorg.pipeline.DeployStage(this, dockerImageName, dockerImageTag, containerName, containerPort)
    deployStage.run()
}