package bd.laboratory.firstlaboratory.modules.examinationResult

import bd.laboratory.firstlaboratory.modules.infrastructure.exceptions.EntityIdNullException
import javax.persistence.EnumType
import javax.persistence.Enumerated

data class ExaminationResultDTO(
        val id: Int,

        val orderNumber: String,

        @Enumerated(EnumType.STRING)
        val examinationType: ExaminationType,

        val unit: String,

        val patientValue: Double? = null,

        val minNormValue: Double,

        val maxNormValue: Double,

        val isDone: Boolean = false
) {
    constructor(examinationResult: ExaminationResult) : this(
            id = examinationResult.id ?: throw EntityIdNullException(ExaminationResult::class),
            orderNumber = examinationResult.orderNumber,
            examinationType = examinationResult.examinationType,
            unit = examinationResult.unit,
            patientValue = examinationResult.patientValue,
            minNormValue = examinationResult.minNormValue,
            maxNormValue = examinationResult.maxNormValue,
            isDone = examinationResult.isDone
    )

    fun toExaminationResultEntity() = ExaminationResult(
            id = this.id,
            orderNumber = this.orderNumber,
            examinationType = this.examinationType,
            unit = this.unit,
            patientValue = this.patientValue,
            minNormValue = this.minNormValue,
            maxNormValue = this.maxNormValue,
            isDone = this.isDone
    )
}