package es.juandavidveg.ticketrestaurantlog.lib.helpers

import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketTypeSaver
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

class TicketTypeSaverSpy(var hasBeenInvoked: Boolean = false) : TicketTypeSaver {

    override fun save(ticketType: TicketType) {
        hasBeenInvoked = true
    }

    fun hasBeenInvoked(): Boolean {
        return hasBeenInvoked
    }

}