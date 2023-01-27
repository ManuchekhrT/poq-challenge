package tj.test.poqchallenge.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import tj.test.poqchallenge.data.remote.RepositoryApi
import tj.test.poqchallenge.presentation.RepositoryItems
import tj.test.poqchallenge.presentation.State
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val api: RepositoryApi,
) : DataRepository {

    override fun fetchRepositories(): Flow<State<RepositoryItems>> {
        return flow {
            val repositories = api.fetchRepositories().map {
                it.toRepositoryItem()
            }
            emit(State.success(repositories))
        }.flowOn(Dispatchers.IO)
    }
}