package userManager.module

import dagger.Module
import dagger.Provides
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import userManager.resource.UserResources
import javax.inject.Named
import javax.ws.rs.core.UriBuilder

@Module
class HttpModule {

    @Provides
    fun provideResource(userResources: UserResources): ResourceConfig {
        return ResourceConfig().register(userResources)
    }

    @Provides
    fun server(@Named("host") host : String,@Named("port") port :Int,config : ResourceConfig): HttpServer{
        val url = UriBuilder.fromUri(host).port(port).build()
        return GrizzlyHttpServerFactory.createHttpServer(url,config)
    }

}