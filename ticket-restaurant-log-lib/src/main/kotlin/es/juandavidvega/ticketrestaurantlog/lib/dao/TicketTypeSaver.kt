package es.juandavidvega.ticketrestaurantlog.lib.dao

import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType

interface TicketTypeSaver {
    fun save(ticketType: TicketType)
}