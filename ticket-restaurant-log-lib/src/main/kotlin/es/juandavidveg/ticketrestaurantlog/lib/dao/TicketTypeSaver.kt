package es.juandavidveg.ticketrestaurantlog.lib.dao

import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

interface TicketTypeSaver {
    fun save(ticketType: TicketType)
}