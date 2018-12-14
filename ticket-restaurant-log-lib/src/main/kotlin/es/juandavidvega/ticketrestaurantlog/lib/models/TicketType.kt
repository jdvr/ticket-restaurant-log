package es.juandavidvega.ticketrestaurantlog.lib.models

data class TicketType (val amount: Int, val currency: String)
class InvalidTicketTypeAmountException: Exception("Amount should be greater than 0")