package tj.test.poqchallenge.data.repository

import kotlinx.coroutines.flow.Flow
import tj.test.poqchallenge.presentation.RepositoryItems
import tj.test.poqchallenge.presentation.State

interface DataRepository {
    fun fetchRepositories(): Flow<State<RepositoryItems>>
}