package es.juandavidveg.ticketrestaurantlog.lib.dao

import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

interface TicketSaver {
    fun save(ticketType: TicketType, number: Int)
}