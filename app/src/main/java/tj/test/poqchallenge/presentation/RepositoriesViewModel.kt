package tj.test.poqchallenge.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import tj.test.poqchallenge.data.repository.DataRepository
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val repository: DataRepository
): ViewModel() {

    private val _repositoryItems = MutableStateFlow<State<RepositoryItems>>(
        State(
            status = Status.LOADING,
            data = listOf(),
        )
    )
    val repositoryItems: StateFlow<State<RepositoryItems>> get() = _repositoryItems

    init {
        fetchRepositoryItems()
    }

    fun fetchRepositoryItems() {
        _repositoryItems.value = State.loading()
        viewModelScope.launch {
            repository.fetchRepositories()
                .catch {
                    _repositoryItems.value = State.error(it.localizedMessage)
                }
                .collectLatest {
                    _repositoryItems.value = State.success(it.data)
                }
        }
    }
}