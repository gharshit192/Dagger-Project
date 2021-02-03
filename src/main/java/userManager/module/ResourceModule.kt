package userManager.module

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides

@Module
class ResourceModule {

    @Provides
    fun provideMapper() : ObjectMapper{
        return ObjectMapper()
    }

}
