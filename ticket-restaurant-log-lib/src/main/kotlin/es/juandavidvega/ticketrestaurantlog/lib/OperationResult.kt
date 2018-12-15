package es.juandavidvega.ticketrestaurantlog.lib

@Suppress("unused")
sealed class OperationResult<out L, out R>

data class Left<out T>(val value: T) : OperationResult<T, Nothing>()
data class Right<out T>(val value: T) : OperationResult<Nothing, T>()

inline fun <L, R, T> OperationResult<L, R>.fold(left: (L) -> T, right: (R) -> T): T =
        when (this) {
            is Left  -> left(value)
            is Right -> right(value)
        }

inline fun <L, R, T> OperationResult<L, R>.flatMap(f: (R) -> OperationResult<L, T>): OperationResult<L, T> =
        fold({ this as Left }, f)

inline fun <L, R, T> OperationResult<L, R>.map(fn: (R) -> T): OperationResult<L, T> =
        flatMap { Right(fn(it)) }

enum class OperationState {
    Valid, Invalid
}