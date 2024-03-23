def call(script, String gitUrl) {
    def checkoutStage = new com.epam.pipeline.CheckoutStage(this, gitUrl)
    checkoutStage.run()
}