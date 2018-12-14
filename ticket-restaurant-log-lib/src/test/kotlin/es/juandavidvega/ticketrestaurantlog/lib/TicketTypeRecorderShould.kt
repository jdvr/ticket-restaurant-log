package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.helpers.TicketTypeSaverSpy
import es.juandavidvega.ticketrestaurantlog.lib.TicketTypeRecorder
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType
import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TicketTypeRecorderShould {

    @Test
    fun invoke_saver_when_new_ticket_is_valid() {
        val saver = TicketTypeSaverSpy()
        val recorder = TicketTypeRecorder(saver)
        recorder.record(TicketType(6, "EUR"))
        assertTrue(saver.hasBeenInvoked())
    }

    @Test
    fun fail_when_ticket_type_amount_is_0() {
        val saver = TicketTypeSaverSpy()
        val recorder = TicketTypeRecorder(saver)
        assertFails { recorder.record(TicketType(0, "EUR")) }
        assertFalse(saver.hasBeenInvoked())
    }

}