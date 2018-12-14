package es.juandavidveg.ticketrestaurantlog.lib.models

data class TicketType (val amount: Int, val currency: String)
class InvalidTicketTypeAmoundException: Exception("Amount should be greater than 0")