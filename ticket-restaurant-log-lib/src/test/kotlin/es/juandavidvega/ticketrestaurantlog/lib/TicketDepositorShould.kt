package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.helpers.TicketSaverSpy
import es.juandavidvega.ticketrestaurantlog.lib.helpers.TicketTypeProviderSpy
import es.juandavidvega.ticketrestaurantlog.lib.TicketDepositor
import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType
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