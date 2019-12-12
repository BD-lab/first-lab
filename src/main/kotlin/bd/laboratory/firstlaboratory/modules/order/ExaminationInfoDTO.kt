package bd.laboratory.firstlaboratory.modules.order

import bd.laboratory.firstlaboratory.modules.examinationResult.ExaminationType

class ExaminationInfoDTO(
        val id: Int?,
        val laboratoryId: Int,
        val type: ExaminationType,
        val isDone: Boolean
)