package tkhub.project.ezysales.repo

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tkhub.project.ezysales.services.network.api.APIInterface
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun provideConversationRepository(aPIInterface: APIInterface): LoginRepo {
        return LoginRepo(
            client = aPIInterface
        )
    }

  /*  @Singleton
    @Provides
    fun provideConversationRepository(aPIInterface: APIInterface,@ApplicationContext appContext: Context): LoginRepo {
        return LoginRepo(
            client = aPIInterface,
            appContext = appContext
        )
    }*/
}