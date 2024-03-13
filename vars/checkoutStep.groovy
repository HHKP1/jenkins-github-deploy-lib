def call(String gitUrl, List<String> branches) {
    def checkoutStage = new com.myorg.pipeline.CheckoutStage(this, gitUrl, branches)
    checkoutStage.run()
}