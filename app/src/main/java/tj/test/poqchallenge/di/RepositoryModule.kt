package tj.test.poqchallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tj.test.poqchallenge.data.remote.RepositoryApi
import tj.test.poqchallenge.data.repository.DataRepository
import tj.test.poqchallenge.data.repository.DataRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDataRepository(
        api: RepositoryApi
    ): DataRepository = DataRepositoryImpl(api)

}