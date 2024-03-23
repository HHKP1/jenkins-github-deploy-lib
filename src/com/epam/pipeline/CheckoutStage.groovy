package com.epam.pipeline

class CheckoutStage implements Serializable {
    def script
    String gitUrl
    List<String> branches

    CheckoutStage(script, String gitUrl, List<String> branches) {
        this.script = script
        this.gitUrl = gitUrl
        this.branches = branches
    }

    def run() {
        script.checkout(
            // branches: branches.collect { [name: it] },
            // changelog: true,
            // clean: true,
            // scm: [$class: 'GitSCM',
                branches: branches.collect { [name: it] },
                userRemoteConfigs: [[url: gitUrl]],
                extensions: [
                    [$class: 'CleanBeforeCheckout']
                ]
            ]
        )
    }
}