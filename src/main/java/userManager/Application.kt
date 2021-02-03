package userManager

import userManager.component.DaggerAppComponent


fun main() {

    val component = DaggerAppComponent.builder().build()
    val httpServer = component.server()
    httpServer.start()
}
