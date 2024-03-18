def call(String dockerImageName, String dockerImageTag) {
    def securityScanStage = new com.epam.pipeline.SecurityScanStage(this, dockerImageName, dockerImageTag)
    securityScanStage.run()
}