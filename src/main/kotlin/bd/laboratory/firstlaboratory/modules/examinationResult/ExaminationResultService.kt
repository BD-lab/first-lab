package bd.laboratory.firstlaboratory.modules.examinationResult

import bd.laboratory.firstlaboratory.modules.order.OrderDTO
import org.springframework.stereotype.Service

@Service
class ExaminationResultService(
        private val examinationResultRepository: ExaminationResultRepository
) {
    fun getAllResultsForOrder(orderNumber: String): List<ExaminationResultDTO> =
            examinationResultRepository.findAllByOrderNumber(orderNumber).map { ExaminationResultDTO(it) }

    fun addExaminations(order: OrderDTO) {
        order.examinations.forEach { examInfo ->
            TODO()
        }
    }
}