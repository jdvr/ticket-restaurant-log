package es.juandavidvega.ticketrestaurantlog.lib.models

data class TicketType (val amount: Int, val currency: String)
class InvalidTicketTypeAmountException: Throwable("Amount should be greater than 0")
class InvalidTicketTypeException(ticketType: TicketType):
        Throwable("Invalid TicketType with amount ${ticketType.amount} and currency ${ticketType.currency}")