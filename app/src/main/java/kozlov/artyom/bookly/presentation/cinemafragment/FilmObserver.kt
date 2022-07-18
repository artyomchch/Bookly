package kozlov.artyom.bookly.presentation.cinemafragment

sealed class FilmObserver<T>(val data: T? = null) {
    class Success<T>(data: T) : FilmObserver<T>(data)
    class Error<T>(data: T? = null) : FilmObserver<T>(data)
}