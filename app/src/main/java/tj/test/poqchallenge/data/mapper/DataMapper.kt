package tj.test.poqchallenge.data.mapper

import tj.test.poqchallenge.data.model.RepositoriesResponse
import tj.test.poqchallenge.presentation.RepositoryItem

fun RepositoriesResponse.toRepositoryItem(): RepositoryItem {
    return RepositoryItem(
        name = this.name ?: "",
        htmlUrl = this.htmlUrl ?: "",
        ownerAvatarUrl = this.owner?.avatarUrl ?: "",
        description = this.description ?: ""
    )
}