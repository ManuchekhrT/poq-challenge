package tj.test.poqchallenge.data.model

import com.google.gson.annotations.SerializedName
import tj.test.poqchallenge.presentation.RepositoryItem

data class RepositoriesResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("owner")
    val owner: RepositoryOwner?,
    @SerializedName("description")
    val description: String?
)

data class RepositoryOwner(
    @SerializedName("avatar_url")
    val avatarUrl: String?
)