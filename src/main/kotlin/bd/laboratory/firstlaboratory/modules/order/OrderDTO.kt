package bd.laboratory.firstlaboratory.modules.order

data class OrderDTO(
        val id: Int,
        val orderNumber: String,
        val patientId: Int,
        val examinations: List<ExaminationInfoDTO>
)