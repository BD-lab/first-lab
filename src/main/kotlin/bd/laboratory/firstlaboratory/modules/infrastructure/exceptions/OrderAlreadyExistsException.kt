package bd.laboratory.firstlaboratory.modules.infrastructure.exceptions

class OrderAlreadyExistsException(orderNumber: String) :
        RuntimeException("Order with number: $orderNumber already exists.")