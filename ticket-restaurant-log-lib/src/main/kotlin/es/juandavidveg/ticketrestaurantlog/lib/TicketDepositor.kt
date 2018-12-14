package es.juandavidveg.ticketrestaurantlog.lib

import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketSaver
import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidveg.ticketrestaurantlog.lib.models.Ticket
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

class TicketDepositor(
        private val saver: TicketSaver,
        private val ticketTypeProvider: TicketTypeProvider) {
    fun deposit(ticketType: TicketType, numberOfTickets: Int) {
        val ticket = Ticket(numberOfTickets, ticketType)
        val ticketTypes = ticketTypeProvider.all()
        if (ticket.type in ticketTypes) {
            saver.save(ticket)
        }
    }


}
