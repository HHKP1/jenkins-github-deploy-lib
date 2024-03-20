package com.epam.pipeline

class TestStage implements Serializable {
    def script
    def utils

    TestStage(script) {
        this.script = script
        this.utils = new Utils(script)
    }

    def run() {
        utils.printMessage('Running tests...')
        script.sh 'npm config ls'
        script.sh 'npm test'
    }
}