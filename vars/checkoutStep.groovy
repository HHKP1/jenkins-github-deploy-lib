def call(script, String branchName, String gitUrl) {
    def checkoutStage = new com.epam.pipeline.CheckoutStage(this, branchName, gitUrl)
    checkoutStage.run()
}