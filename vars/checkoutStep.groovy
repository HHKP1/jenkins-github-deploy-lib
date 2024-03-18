def call(String gitUrl, List<String> branches) {
    def checkoutStage = new com.epam.pipeline.CheckoutStage(this, gitUrl, branches)
    checkoutStage.run()
}