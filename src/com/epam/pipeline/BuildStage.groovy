package com.myorg.pipeline

class BuildStage implements Serializable {
    def utils = new Utils()

    def run() {
        utils.printMessage('Building the application...')
        sh "ls -la && pwd"
        sh 'npm config ls'
        sh 'npm install'
    }
}