package bd.laboratory.firstlaboratory.modules.examinationResult

import bd.laboratory.firstlaboratory.modules.infrastructure.exceptions.EntityIdNullException
import bd.laboratory.firstlaboratory.modules.infrastructure.exceptions.EntityNotFoundException
import bd.laboratory.firstlaboratory.modules.order.OrderDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ExaminationResultService(
        private val examinationResultRepository: ExaminationResultRepository
) {
    fun getAllResultsForOrder(orderNumber: String): List<ExaminationResultDTO> =
            examinationResultRepository.findAllByOrderNumber(orderNumber).map { ExaminationResultDTO(it) }

    fun addExaminations(order: OrderDTO) {
        ExaminationResultMapper.mapOrderToExaminationResults(order).forEach { examResult ->
            if (!examinationResultExistsById(examResult.id))
                examinationResultRepository.save(examResult)
        }
    }

    fun updatePatientValue(examinationResultId: Int, patientValue: Double): ExaminationResultDTO {
        val updatedExaminationResult = findExaminationResultOrThrow(examinationResultId).apply {
            this.patientValue = patientValue
            this.isDone = true
        }
        return ExaminationResultDTO(examinationResultRepository.save(updatedExaminationResult))
    }

    private fun findExaminationResultOrThrow(examinationResultId: Int): ExaminationResult =
            examinationResultRepository.findByIdOrNull(examinationResultId)
                    ?: throw EntityNotFoundException(ExaminationResult::class, examinationResultId)

    private fun examinationResultExistsById(examinationResultId: Int?): Boolean =
            examinationResultRepository.existsById(
                    examinationResultId ?: throw EntityIdNullException(ExaminationResult::class)
            )

}