package es.juandavidvega.ticketrestaurantlog.lib.helpers

import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketTypeSaver
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType

class TicketTypeSaverSpy(var hasBeenInvoked: Boolean = false) : TicketTypeSaver {

    override fun save(ticketType: TicketType) {
        hasBeenInvoked = true
    }

    fun hasBeenInvoked(): Boolean {
        return hasBeenInvoked
    }

}