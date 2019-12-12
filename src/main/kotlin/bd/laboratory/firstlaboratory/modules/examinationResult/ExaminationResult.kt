package bd.laboratory.firstlaboratory.modules.examinationResult

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
class ExaminationResult(
        @Id
        val id: Int? = null,

        val orderNumber: String,

        @Enumerated(EnumType.STRING)
        val examinationType: ExaminationType,

        val unit: String,

        val patientValue: Double? = null,

        val minNormValue: Double,

        val maxNormValue: Double,

        val isDone: Boolean = false
)