package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.dao.TicketTypeSaver
import es.juandavidvega.ticketrestaurantlog.lib.models.InvalidTicketTypeAmountException
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType

class TicketTypeRecorder(val saver: TicketTypeSaver) {
    fun record(ticketType: TicketType) {
        if (ticketType.amount <= 0) {
            throw InvalidTicketTypeAmountException()
        }
        saver.save(ticketType)
    }

}
