def call(String dockerImageName, String dockerImageTag, String containerName, int hostPort, int containerPort) {
    def deployStage = new com.epam.pipeline.DeployStage(this, dockerImageName, dockerImageTag, containerName, hostPort, containerPort)
    deployStage.run()
}