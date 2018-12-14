package es.juandavidveg.ticketrestaurantlog.lib

import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketSaver
import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

class TicketDepositor(
        private val saver: TicketSaver,
        private val ticketTypeProvider: TicketTypeProvider) {
    fun deposit(ticketType: TicketType, numberOfTickets: Int) {
        val ticketTypes = ticketTypeProvider.all()
        if (ticketType in ticketTypes) {
            saver.save(ticketType, numberOfTickets)
        }
    }


}
