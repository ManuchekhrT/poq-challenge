package tj.test.poqchallenge.presentation

typealias RepositoryItems = List<RepositoryItem>

data class State<out T>(val status: Status, val data: T? = null, val message: String? = null) {
    companion object {
        fun <T> success(data: T?): State<T> {
            return State(Status.SUCCESS, data, null)
        }

        fun <T> empty(): State<T> {
            return State(Status.SUCCESS, null, null)
        }

        fun <T> error(msg: String?): State<T> {
            return State(Status.ERROR, null, msg)
        }

        fun <T> loading(): State<T> {
            return State(Status.LOADING, null, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}