package tj.test.poqchallenge

import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import tj.test.poqchallenge.data.model.RepositoriesResponse
import tj.test.poqchallenge.data.model.RepositoryOwner
import tj.test.poqchallenge.data.remote.RepositoryApi
import tj.test.poqchallenge.data.repository.DataRepository
import tj.test.poqchallenge.data.repository.DataRepositoryImpl
import tj.test.poqchallenge.presentation.RepositoryItem
import tj.test.poqchallenge.presentation.Status

class DataRepositoryTest {
    lateinit var dataRepository: DataRepository

    @Mock
    lateinit var api: RepositoryApi

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        dataRepository = DataRepositoryImpl(api)
    }

    @Test
    fun `fetch repositories test`() {
        runBlocking {
            val response = listOf(
                RepositoriesResponse(
                    "Manu", "https://github.com/square/Manu",
                    RepositoryOwner("https://avatars.githubusercontent.com/u/82592?v=4"),
                    "Lorem ipsum"
                )
            )
            val repositoryItems = response.map { it.toRepositoryItem() }
            Mockito.`when`(api.fetchRepositories()).thenReturn(response)
            dataRepository.fetchRepositories().collectLatest {
                if (it.status == Status.SUCCESS) {
                    assertEquals(repositoryItems, it.data)
                }
            }
        }
    }

    @Test
    fun `empty repositories test`() {
        runBlocking {
            Mockito.`when`(api.fetchRepositories()).thenReturn(listOf())
            dataRepository.fetchRepositories().collectLatest {
                if (it.status == Status.SUCCESS) {
                    assertEquals(listOf<RepositoryItem>(), it.data)
                }
            }
        }
    }
}