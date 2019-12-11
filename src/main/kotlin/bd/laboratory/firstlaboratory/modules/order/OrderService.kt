package bd.laboratory.firstlaboratory.modules.order

import bd.clinic.modules.order.OrderDTO
import bd.laboratory.firstlaboratory.modules.infrastructure.exceptions.EntityNotFoundException
import bd.laboratory.firstlaboratory.modules.infrastructure.exceptions.OrderAlreadyExistsException
import bd.laboratory.firstlaboratory.modules.infrastructure.exceptions.OrderWithNumberNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderService(
        private val orderRepository: OrderRepository
) {
    fun getOrder(orderId: Int) = OrderDTO(
            orderRepository.findByIdOrNull(orderId) ?: throw EntityNotFoundException(Order::class, orderId)
    )

    fun getOrderByNumber(orderNumber: String) = OrderDTO(
            orderRepository.findByOrderNumber(orderNumber) ?: throw OrderWithNumberNotFoundException(orderNumber)
    )

    fun getAllOrders(): List<OrderDTO> = orderRepository.findAll().map { OrderDTO(it) }

    fun getAllPatientOrders(patientId: Int): List<OrderDTO> {
        return orderRepository.findAllByPatientId(patientId).map { OrderDTO(it) }
    }

    fun addPatientOrder(order: OrderDTO): OrderDTO {
        checkIfOrderNumberIsUnique(order.orderNumber)
        return OrderDTO(orderRepository.save(order.toOrderEntity()))
    }

    private fun checkIfOrderNumberIsUnique(orderNumber: String) {
        if (orderRepository.existsByOrderNumber(orderNumber))
            throw OrderAlreadyExistsException(orderNumber)
    }
}