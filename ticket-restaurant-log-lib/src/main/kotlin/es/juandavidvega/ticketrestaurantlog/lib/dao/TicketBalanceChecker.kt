package es.juandavidvega.ticketrestaurantlog.lib.dao

import es.juandavidvega.ticketrestaurantlog.lib.OperationResult
import es.juandavidvega.ticketrestaurantlog.lib.OperationState
import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket

interface TicketBalanceChecker {
    fun check(ticket: Ticket): OperationResult<Throwable, OperationState>
}