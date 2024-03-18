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
            [$class: 'GitSCM',
             branches: branches.collect { [name: it] },
             userRemoteConfigs: [[url: gitUrl]]]
        )
    }
}