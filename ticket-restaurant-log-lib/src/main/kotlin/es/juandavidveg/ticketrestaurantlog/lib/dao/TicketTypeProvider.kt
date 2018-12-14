package es.juandavidveg.ticketrestaurantlog.lib.dao

import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

interface TicketTypeProvider {
    fun all(): List<TicketType>
}