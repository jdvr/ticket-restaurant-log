package es.juandavidveg.ticketrestaurantlog.lib.dao

import es.juandavidveg.ticketrestaurantlog.lib.models.Ticket

interface TicketSaver {
    fun save(ticket: Ticket)
}