package es.juandavidvega.ticketrestaurantlog.lib.dao

import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket

interface TicketSaver {
    fun save(ticket: Ticket)
}