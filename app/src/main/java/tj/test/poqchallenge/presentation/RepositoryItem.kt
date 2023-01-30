package tj.test.poqchallenge.presentation

data class RepositoryItem(
    val name: String,
    val htmlUrl: String,
    val ownerAvatarUrl: String,
    val description: String,
    val isPrivate: Boolean,
    val forksCount: Int,
    val starsCount: Int,
    val issuesCount: Int,
    val language: String
)