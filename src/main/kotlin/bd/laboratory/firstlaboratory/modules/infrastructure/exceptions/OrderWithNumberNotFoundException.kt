package bd.laboratory.firstlaboratory.modules.infrastructure.exceptions

class OrderWithNumberNotFoundException(orderNumber: String) :
        RuntimeException("Order with number: $orderNumber not found.")