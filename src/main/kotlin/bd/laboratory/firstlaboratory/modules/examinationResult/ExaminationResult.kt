package bd.laboratory.firstlaboratory.modules.examinationResult

import bd.laboratory.firstlaboratory.modules.examinationInfo.ExaminationInfo
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.OneToOne

@Entity
class ExaminationResult(
        val id: Int? = null,
        @OneToOne
        val examinationInfo: ExaminationInfo,
        val orderNumber: String,
        @Enumerated(EnumType.STRING)
        val examinationType: ExaminationType,
        val unit: String,
        val patientValue: Double,
        val minNormValue: Double,
        val maxNormValue: Double
)