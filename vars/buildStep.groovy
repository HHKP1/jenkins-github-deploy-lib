def call(script) {
    def buildStage = new com.epam.pipeline.BuildStage(script)
    buildStage.run()
}