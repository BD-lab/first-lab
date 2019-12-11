package bd.clinic.modules.order

import bd.laboratory.firstlaboratory.modules.examinationInfo.ExaminationInfoDTO
import bd.laboratory.firstlaboratory.modules.order.Order

data class OrderDTO(
        val id: Int? = null,
        val orderNumber: String,
        val patientId: Int,
        val examinations: List<ExaminationInfoDTO>
) {
    constructor(order: Order) : this(
            id = order.id,
            orderNumber = order.orderNumber,
            patientId = order.patientId,
            examinations = order.examinations.map { ExaminationInfoDTO(it) }
    )

    fun toOrderEntity() = Order(
            id = this.id,
            orderNumber = this.orderNumber,
            patientId = this.patientId,
            examinations = this.examinations.map { it.toExaminationEntity() }
    )
}