package es.juandavidveg.ticketrestaurantlog.lib

import es.juandavidveg.ticketrestaurantlog.lib.dao.TicketTypeSaver
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType

class TicketTypeRecorder(val saver: TicketTypeSaver) {
    fun record(ticketType: TicketType) {
        saver.save(ticketType)
    }

}
