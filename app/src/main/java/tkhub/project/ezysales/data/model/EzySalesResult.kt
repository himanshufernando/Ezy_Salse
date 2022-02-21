package tkhub.project.ezysales.data.model




sealed  class EzySalesResult <out T : Any>{
     class Success<out T : Any>(val data: T) : EzySalesResult<T>()
     sealed class ExceptionError(val exception: Exception) : EzySalesResult<Nothing>() {
          class ExError(exception: Exception) : ExceptionError(exception)
     }
     sealed class LogicalError(val exception: BaseApiModal) : EzySalesResult<Nothing>() {
          class LogError(exception: BaseApiModal) : LogicalError(exception)
     }
}