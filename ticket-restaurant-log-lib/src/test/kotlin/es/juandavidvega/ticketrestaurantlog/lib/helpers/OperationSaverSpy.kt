package es.juandavidvega.ticketrestaurantlog.lib.helpers

import es.juandavidvega.ticketrestaurantlog.lib.dao.OperationSaver
import es.juandavidvega.ticketrestaurantlog.lib.models.Operation

class OperationSaverSpy(var hasBeenInvoked: Boolean = false,
                        var argument: Operation? = null) : OperationSaver {
    override fun save(operation: Operation) {
        argument = operation
        hasBeenInvoked = true
    }

    fun hasBeenInvoked() =
            hasBeenInvoked
    fun hasBeenCalledWith(operation: Operation) =
            argument != null && argument == operation

}