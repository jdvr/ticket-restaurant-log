package es.juandavidveg.ticketrestaurantlog.lib.helpers

import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketSaver
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

class TicketSaverSpy(var hasBeenInvoked: Boolean = false) : TicketSaver {
    override fun save(ticketType: TicketType, number: Int) {
        hasBeenInvoked = true
    }

    fun hasBeenInvoked(): Boolean {
        return hasBeenInvoked
    }

}