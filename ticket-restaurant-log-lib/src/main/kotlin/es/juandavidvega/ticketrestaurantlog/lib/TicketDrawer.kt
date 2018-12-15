package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketBalanceChecker
import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket

class TicketDrawer(private val ticketTypeProvider: TicketTypeProvider,
                   private val ticketBalanceChecker: TicketBalanceChecker) {

    fun draw(operations: List<Ticket>): OperationResult<Throwable, OperationState> {
        return Right(OperationState.Valid)
    }

}