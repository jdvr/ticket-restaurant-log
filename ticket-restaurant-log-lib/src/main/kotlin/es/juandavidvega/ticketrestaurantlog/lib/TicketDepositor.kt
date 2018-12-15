package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketSaver
import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidvega.ticketrestaurantlog.lib.models.InvalidTicketTypeAmountException
import es.juandavidvega.ticketrestaurantlog.lib.models.InvalidTicketTypeException
import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType

class TicketDepositor(
        private val saver: TicketSaver,
        private val ticketTypeProvider: TicketTypeProvider) {
    fun deposit(ticketType: TicketType, numberOfTickets: Int) {
        val ticket = Ticket(numberOfTickets, ticketType)
        val ticketTypes = ticketTypeProvider.all()
        if (ticket.type !in ticketTypes) {
            throw InvalidTicketTypeException(ticketType)
        }
        saver.save(ticket)

    }


}
