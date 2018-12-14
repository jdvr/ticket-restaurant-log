package es.juandavidvega.ticketrestaurantlog.lib.dao

import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType

interface TicketTypeProvider {
    fun all(): List<TicketType>
}