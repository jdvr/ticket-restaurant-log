package es.juandavidvega.ticketrestaurantlog.lib.helpers

import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketTypeProvider
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType

class TicketTypeProviderSpy(private val ticketTypes: List<TicketType>, var hasBeenInvoked: Boolean = false) : TicketTypeProvider {
    override fun all(): List<TicketType> {
        hasBeenInvoked = true
        return ticketTypes
    }

    fun hasBeenInvoked() = hasBeenInvoked

}