package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.helpers.OperationSaverSpy
import es.juandavidvega.ticketrestaurantlog.lib.helpers.TicketTypeProviderSpy
import es.juandavidvega.ticketrestaurantlog.lib.models.Operation
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType
import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OperationDepositorShould {

    @Test
    fun save_deposit() {
        val anyAmountOfTickets = 43
        val anyTicketTypeAmount = 6
        val anyTicketTypeCurrency = "EUR"
        val existingTicketType = TicketType(anyTicketTypeAmount, anyTicketTypeCurrency)
        val saver = OperationSaverSpy()
        val ticketTypeProvider = TicketTypeProviderSpy(listOf(existingTicketType))
        val depositor = Depositor(saver, ticketTypeProvider)

        depositor.deposit(TicketType(anyTicketTypeAmount, anyTicketTypeCurrency), anyAmountOfTickets)

        assertTrue(saver.hasBeenInvoked())
        assertTrue(ticketTypeProvider.hasBeenInvoked())
        assertTrue(saver.hasBeenCalledWith(Operation(anyAmountOfTickets, existingTicketType)))
    }


    @Test
    fun fails_when_ticket_type_doesnt_exists() {
        val anyAmountOfTickets = 43
        val anyTicketTypeAmount = 6
        val anyTicketTypeCurrency = "EUR"
        val invalidTicketType = TicketType(anyTicketTypeAmount, anyTicketTypeCurrency)
        val saver = OperationSaverSpy()
        val ticketTypeProvider = TicketTypeProviderSpy(emptyList())
        val depositor = Depositor(saver, ticketTypeProvider)

        assertFails {
            depositor.deposit(invalidTicketType, anyAmountOfTickets)
        }

        assertTrue(ticketTypeProvider.hasBeenInvoked())
        assertFalse(saver.hasBeenInvoked())

    }
}