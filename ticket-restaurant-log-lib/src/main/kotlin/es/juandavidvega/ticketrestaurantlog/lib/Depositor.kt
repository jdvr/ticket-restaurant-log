package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.dao.OperationSaver
import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidvega.ticketrestaurantlog.lib.models.InvalidTicketTypeException
import es.juandavidvega.ticketrestaurantlog.lib.models.Operation
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType

class Depositor(
        private val saver: OperationSaver,
        private val ticketTypeProvider: TicketTypeProvider) {
    fun deposit(ticketType: TicketType, amount: Int) {
        val operation = Operation(amount, ticketType)
        val ticketTypes = ticketTypeProvider.all()
        if (operation.type !in ticketTypes) {
            throw InvalidTicketTypeException(ticketType)
        }
        saver.save(operation)

    }


}
