package es.juandavidveg.ticketrestaurantlog.lib

import es.juandavidveg.ticketrestaurantlog.lib.helpers.TicketSaverSpy
import es.juandavidveg.ticketrestaurantlog.lib.helpers.TicketTypeProviderSpy
import es.juandavidveg.ticketrestaurantlog.lib.models.Ticket
import es.juandavidveg.ticketrestaurantlog.lib.models.TicketType
import kotlin.test.Test
import kotlin.test.assertTrue

class TicketDepositorShould {

    @Test
    fun save_deposit() {
        val anyAmountOfTickets = 43
        val anyTicketTypeAmount = 6
        val anyTicketTypeCurrency = "EUR"
        val existingTicketType = TicketType(anyTicketTypeAmount, anyTicketTypeCurrency)
        val saver = TicketSaverSpy()
        val ticketTypeProvider = TicketTypeProviderSpy(listOf(existingTicketType))
        val depositor = TicketDepositor(saver, ticketTypeProvider)

        depositor.deposit(TicketType(anyTicketTypeAmount, anyTicketTypeCurrency), anyAmountOfTickets)

        assertTrue(saver.hasBeenInvoked())
        assertTrue(ticketTypeProvider.hasBeenInvoked())
        assertTrue(saver.hasBeenCalledWith(Ticket(anyAmountOfTickets, existingTicketType)))
    }

}