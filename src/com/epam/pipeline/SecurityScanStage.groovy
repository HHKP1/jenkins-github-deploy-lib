package com.epam.pipeline

class SecurityScanStage implements Serializable {
    def script
    String dockerImageName
    String dockerImageTag

    SecurityScanStage(script, String dockerImageName, String dockerImageTag) {
        this.script = script
        this.dockerImageName = dockerImageName
        this.dockerImageTag = dockerImageTag
    }

    def run() {
        def vulnerabilities = script.sh(script: "trivy image --exit-code 0 --severity HIGH,MEDIUM,LOW --no-progress ${dockerImageName}:${dockerImageTag}", returnStdout: true).trim()
        script.writeFile file: 'vulnerabilities.txt', text: vulnerabilities
    }
}