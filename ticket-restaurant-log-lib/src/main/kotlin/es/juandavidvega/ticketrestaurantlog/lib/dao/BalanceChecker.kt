package es.juandavidvega.ticketrestaurantlog.lib.dao

import es.juandavidvega.ticketrestaurantlog.lib.OperationResult
import es.juandavidvega.ticketrestaurantlog.lib.OperationState
import es.juandavidvega.ticketrestaurantlog.lib.models.Operation

interface BalanceChecker {
    fun check(operation: Operation): OperationResult<Throwable, OperationState>
}