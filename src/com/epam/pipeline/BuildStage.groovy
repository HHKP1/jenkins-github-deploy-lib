package com.epam.pipeline

class BuildStage implements Serializable {
    def script
    def utils
    
    BuildStage(script) {
        this.script = script
        this.utils = new Utils(script)
    }

    def run() {
        utils.printMessage('Building the application...')
        script.sh "ls -la && pwd"
        script.sh 'npm config ls'
        script.sh 'npm install'
    }
}