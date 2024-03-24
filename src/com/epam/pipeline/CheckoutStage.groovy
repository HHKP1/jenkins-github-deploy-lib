package com.epam.pipeline

class CheckoutStage implements Serializable {
    def script
    String gitUrl

    CheckoutStage(script, String gitUrl) {
        this.script = script
        this.gitUrl = gitUrl
    }

    def run() {
        script.checkout([$class: 'GitSCM',
                branches: [[name: 'main']],
                userRemoteConfigs: [[url: gitUrl]],
                extensions: [
                    [$class: 'CleanBeforeCheckout']
                ]
            ]
        )
    }
}