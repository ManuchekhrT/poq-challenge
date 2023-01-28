package tj.test.poqchallenge.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tj.test.poqchallenge.data.repository.DataRepository
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {

    private val _repositoryItems = MutableStateFlow<State<RepositoryItems>>(State.Loading)
    val repositoryItems: StateFlow<State<RepositoryItems>> get() = _repositoryItems

    init {
        fetchRepositoryItems()
    }

    fun fetchRepositoryItems() {
        viewModelScope.launch {
            repository.fetchRepositories()
                .onStart {
                    _repositoryItems.value = State.Loading
                }
                .catch {
                    _repositoryItems.value = State.Error(message = it.localizedMessage)
                }
                .collectLatest {
                    when(it) {
                        is State.Success -> _repositoryItems.value = State.Success(data = it.data)
                        is State.Error -> _repositoryItems.value = State.Error(it.message)
                        else -> _repositoryItems.value = State.Loading
                    }
                }
        }
    }
}