package tj.test.poqchallenge.data.remote

import retrofit2.http.GET
import tj.test.poqchallenge.data.model.RepositoriesResponse

interface RepositoryApi {
    companion object {
        const val BASE_API = "https://api.github.com/"
    }

    @GET("orgs/square/repos")
    suspend fun fetchRepositories(): List<RepositoriesResponse>
}