package es.juandavidvega.ticketrestaurantlog.lib.helpers

import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketSaver
import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket

class TicketSaverSpy(var hasBeenInvoked: Boolean = false,
                     var argument: Ticket? = null) : TicketSaver {
    override fun save(ticket: Ticket) {
        argument = ticket
        hasBeenInvoked = true
    }

    fun hasBeenInvoked() =
            hasBeenInvoked
    fun hasBeenCalledWith(ticket: Ticket) =
            argument != null && argument == ticket

}