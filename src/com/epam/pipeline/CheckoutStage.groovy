package com.epam.pipeline

class CheckoutStage implements Serializable {
    def script
    String branchName
    String gitUrl

    CheckoutStage(script, String branchName, String gitUrl) {
        this.script = script
        this.branchName = branchName
        this.gitUrl = gitUrl
    }

    def run() {
        script.checkout([$class: 'GitSCM',
                branches: [[name: branchName ]],
                userRemoteConfigs: [[url: gitUrl]],
                extensions: [
                    [$class: 'CleanBeforeCheckout']
                ]
            ]
        )
    }
}