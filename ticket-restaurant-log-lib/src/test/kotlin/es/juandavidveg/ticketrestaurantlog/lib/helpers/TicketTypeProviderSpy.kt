package es.juandavidveg.ticketrestaurantlog.lib.helpers

import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

class TicketTypeProviderSpy(private val ticketTypes: List<TicketType>, var hasBeenInvoked: Boolean = false) : TicketTypeProvider {
    override fun all(): List<TicketType> {
        hasBeenInvoked = true
        return ticketTypes
    }

    fun hasBeenInvoked() = hasBeenInvoked

}