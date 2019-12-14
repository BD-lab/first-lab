package bd.laboratory.firstlaboratory.modules.examinationResult

import bd.laboratory.firstlaboratory.modules.order.OrderDTO

object ExaminationResultMapper {

    fun mapOrderToExaminationResults(order: OrderDTO): List<ExaminationResult> {
        val examinations = order.examinations
        return examinations.map { examInfo ->
            ExaminationResult(
                    id = examInfo.id,
                    orderNumber = order.orderNumber,
                    examinationType = examInfo.type,
                    unit = examInfo.type.unit,
                    patientValue = null,
                    minNormValue = examInfo.type.minNormValue,
                    maxNormValue = examInfo.type.maxNormValue,
                    isDone = examInfo.isDone
            )
        }
    }
}