package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.helpers.TicketBalanceCheckerSpy
import es.juandavidvega.ticketrestaurantlog.lib.helpers.TicketTypeProviderSpy
import es.juandavidvega.ticketrestaurantlog.lib.models.Ticket
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType
import kotlin.test.*

class TicketDrawerShould {

    @Test
    fun returns_valid_when_ticket_are_draw()    {
        val anyTicketType = TicketType(4, "ANY")
        val aValidOperation = listOf(Ticket(1, anyTicketType))
        val ticketTypeProvider = TicketTypeProviderSpy(listOf(anyTicketType))
        val ticketBalanceChecker = TicketBalanceCheckerSpy(aValidOperation)
        val drawer = TicketDrawer(ticketTypeProvider, ticketBalanceChecker)
        val result = drawer.draw(aValidOperation)
        result.fold(
                left = { assertFalse(true) },// force fails
                right = { assertEquals(OperationState.Valid, it)}
        )

    }
}