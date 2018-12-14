package es.juandavidveg.ticketrestaurantlog.lib

import es.juandavidveg.ticketrestaurantlog.lib.helpers.TicketSaverSpy
import es.juandavidveg.ticketrestaurantlog.lib.helpers.TicketTypeProviderSpy
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType
import kotlin.test.Test
import kotlin.test.assertTrue

class TicketDepositorShould {

    @Test
    fun save_deposit() {
        val saver = TicketSaverSpy()
        val anyTicketTypeAmount = 6
        val anyTicketTypeCurrency = "EUR"
        val ticketTypeProvider = TicketTypeProviderSpy(listOf(TicketType(anyTicketTypeAmount, anyTicketTypeCurrency)))
        val depositor = TicketDepositor(saver, ticketTypeProvider)
        depositor.deposit(TicketType(anyTicketTypeAmount, anyTicketTypeCurrency), 43)
        assertTrue(saver.hasBeenInvoked())
        assertTrue(ticketTypeProvider.hasBeenInvoked())
    }

}