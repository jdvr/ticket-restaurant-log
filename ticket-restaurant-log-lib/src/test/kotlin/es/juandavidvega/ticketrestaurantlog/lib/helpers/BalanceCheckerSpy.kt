package es.juandavidvega.ticketrestaurantlog.lib.helpers

import es.juandavidvega.ticketrestaurantlog.lib.OperationResult
import es.juandavidvega.ticketrestaurantlog.lib.OperationState
import es.juandavidvega.ticketrestaurantlog.lib.Right
import es.juandavidvega.ticketrestaurantlog.lib.dao.BalanceChecker
import es.juandavidvega.ticketrestaurantlog.lib.models.Operation

class BalanceCheckerSpy(private val validOperations: List<Operation>, var hasBeenInvoked: Boolean = false): BalanceChecker {
    override fun check(operation: Operation): OperationResult<Throwable, OperationState> {
        hasBeenInvoked = true
        return if (operation in validOperations) {
            Right(OperationState.Valid)
        } else {
            Right(OperationState.Invalid)
        }
    }


}