def call(String dockerImageName, String dockerImageTag) {
    def securityScanStage = new com.myorg.pipeline.SecurityScanStage(this, dockerImageName, dockerImageTag)
    securityScanStage.run()
}