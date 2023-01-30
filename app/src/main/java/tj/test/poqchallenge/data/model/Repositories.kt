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
    val description: String?,
    @SerializedName("private")
    val private: Boolean?,
    @SerializedName("forks_count")
    val forksCount: Int?,
    @SerializedName("stargazers_count")
    val starGazersCount: Int?,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int?,
    @SerializedName("language")
    val language: String?
)

data class RepositoryOwner(
    @SerializedName("avatar_url")
    val avatarUrl: String?
)