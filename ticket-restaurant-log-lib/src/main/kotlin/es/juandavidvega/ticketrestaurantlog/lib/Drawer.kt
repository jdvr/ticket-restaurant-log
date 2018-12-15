package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.dao.BalanceChecker
import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidvega.ticketrestaurantlog.lib.models.Operation

class Drawer(private val ticketTypeProvider: TicketTypeProvider,
             private val balanceChecker: BalanceChecker) {

    fun draw(operations: List<Operation>): OperationResult<Throwable, OperationState> {
        return Right(OperationState.Valid)
    }

}