package com.epam.pipeline

class Utils implements Serializable {
    def script

    Utils(script) {
        this.script = script
    }

    def printMessage(String message) {
        script.echo ">>> ${message}"
    }
}