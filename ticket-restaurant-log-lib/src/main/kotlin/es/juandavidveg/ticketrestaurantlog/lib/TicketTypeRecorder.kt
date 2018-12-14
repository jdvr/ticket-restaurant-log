package es.juandavidveg.ticketrestaurantlog.lib

import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketTypeSaver
import es.juandavidveg.ticketrestaurantlog.lib.models.InvalidTicketTypeAmoundException
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

class TicketTypeRecorder(val saver: TicketTypeSaver) {
    fun record(ticketType: TicketType) {
        if (ticketType.amount <= 0) {
            throw InvalidTicketTypeAmoundException()
        }
        saver.save(ticketType)
    }

}
