package es.juandavidveg.ticketrestaurantlog.lib

import es.juandavidveg.ticketrestaurantlog.lib.helpers.TicketTypeSaverSpy
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType
import kotlin.test.Test
import kotlin.test.assertTrue

class TicketTypeRecorderShould {

    @Test
    fun invoke_saver_when_new_ticket_is_valid() {
        val saver = TicketTypeSaverSpy()
        val recorder = TicketTypeRecorder(saver)
        recorder.record(TicketType(6, "EUR"))
        assertTrue(saver.hasBeenInvoked())
    }

}