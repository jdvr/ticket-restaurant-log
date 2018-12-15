package es.juandavidvega.ticketrestaurantlog.lib.dao

import es.juandavidvega.ticketrestaurantlog.lib.models.Operation

interface OperationSaver {
    fun save(operation: Operation)
}