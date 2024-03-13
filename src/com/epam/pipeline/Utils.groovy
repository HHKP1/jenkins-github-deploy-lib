package com.myorg.pipeline

class Utils implements Serializable {
    def printMessage(String message) {
        echo ">>> ${message}"
    }
}