package bd.laboratory.firstlaboratory.modules.order

import bd.laboratory.firstlaboratory.modules.examinationResult.ExaminationType

class ExaminationInfoDTO(
        val id: Int? = null,
        val laboratoryId: Int,
        val type: ExaminationType,
        val isDone: Boolean = false
)