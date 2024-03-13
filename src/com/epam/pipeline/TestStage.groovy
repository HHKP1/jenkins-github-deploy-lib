package com.myorg.pipeline

class TestStage implements Serializable {
    def utils = new Utils()

    def run() {
        utils.printMessage('Running tests...')
        sh 'npm config ls'
        sh 'npm test'
    }
}