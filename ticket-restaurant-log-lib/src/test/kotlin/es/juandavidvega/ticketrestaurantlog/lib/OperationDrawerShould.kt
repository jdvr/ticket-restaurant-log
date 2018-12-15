package es.juandavidvega.ticketrestaurantlog.lib

import es.juandavidvega.ticketrestaurantlog.lib.helpers.BalanceCheckerSpy
import es.juandavidvega.ticketrestaurantlog.lib.helpers.TicketTypeProviderSpy
import es.juandavidvega.ticketrestaurantlog.lib.models.Operation
import es.juandavidvega.ticketrestaurantlog.lib.models.TicketType
import kotlin.test.*

class OperationDrawerShould {

    @Test
    fun returns_valid_when_ticket_are_draw()    {
        val anyTicketType = TicketType(4, "ANY")
        val aValidOperation = listOf(Operation(1, anyTicketType))
        val ticketTypeProvider = TicketTypeProviderSpy(listOf(anyTicketType))
        val ticketBalanceChecker = BalanceCheckerSpy(aValidOperation)
        val drawer = Drawer(ticketTypeProvider, ticketBalanceChecker)
        val result = drawer.draw(aValidOperation)
        result.fold(
                left = { assertFalse(true) },// force fails
                right = { assertEquals(OperationState.Valid, it)}
        )

    }
}