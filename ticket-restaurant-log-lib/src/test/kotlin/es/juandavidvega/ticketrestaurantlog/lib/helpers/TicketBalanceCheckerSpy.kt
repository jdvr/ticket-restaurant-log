package es.juandavidvega.ticketrestaurantlog.lib.helpers

import es.juandavidvega.ticketrestaurantlog.lib.OperationResult
import es.juandavidvega.ticketrestaurantlog.lib.OperationState
import es.juandavidvega.ticketrestaurantlog.lib.Right
import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketBalanceChecker
import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket

class TicketBalanceCheckerSpy(private val validOperations: List<Ticket>, var hasBeenInvoked: Boolean = false): TicketBalanceChecker {
    override fun check(ticket: Ticket): OperationResult<Throwable, OperationState> {
        hasBeenInvoked = true
        return if (ticket in validOperations) {
            Right(OperationState.Valid)
        } else {
            Right(OperationState.Invalid)
        }
    }


}