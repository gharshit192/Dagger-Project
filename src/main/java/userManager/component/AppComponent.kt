package userManager.component

import dagger.Component
import org.glassfish.grizzly.http.server.HttpServer
import userManager.module.*
import javax.inject.Singleton

@Singleton
@Component ( modules = [
    ConfigModule::class,
    HttpModule::class,
    ResourceModule::class
    ]
)
interface AppComponent{
    fun server() : HttpServer
}