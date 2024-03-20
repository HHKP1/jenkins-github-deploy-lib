def call(script) {
    def testStage = new com.epam.pipeline.TestStage(script)
    testStage.run()
}