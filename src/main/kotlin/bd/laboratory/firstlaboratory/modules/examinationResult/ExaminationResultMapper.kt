package bd.laboratory.firstlaboratory.modules.examinationResult

import bd.laboratory.firstlaboratory.modules.examinationResult.ExaminationType.*
import bd.laboratory.firstlaboratory.modules.order.OrderDTO

object ExaminationResultMapper {
    private data class ReferenceRange(val unit: String, val minNormValue: Double, val maxNormValue: Double)

    private fun ExaminationType.getReferenceRange() = when (this) {
        // TODO: Proper values
        BLOOD_HORMONE_TEST -> ReferenceRange(unit = "abc", minNormValue = 2.0, maxNormValue = 15.0)
        BLOOD_GLUCOSE_TEST -> ReferenceRange(unit = "glukoza", minNormValue = 2.04, maxNormValue = 15.10)
        HEMOGLOBIN_TEST -> ReferenceRange(unit = "cba", minNormValue = 2.120, maxNormValue = 15.20)
        BLOOD_THYROID_TEST -> ReferenceRange(unit = "asd", minNormValue = 2.30, maxNormValue = 15.50)
    }

    fun mapOrderToExaminationResults(order: OrderDTO): List<ExaminationResult> {
        val examinations = order.examinations
        return examinations.map { examInfo ->
            val (unit, minNormValue, maxNormValue) = examInfo.type.getReferenceRange()
            ExaminationResult(
                    id = examInfo.id,
                    orderNumber = order.orderNumber,
                    examinationType = examInfo.type,
                    unit = unit,
                    patientValue = null,
                    minNormValue = minNormValue,
                    maxNormValue = maxNormValue,
                    isDone = examInfo.isDone
            )
        }
    }
}