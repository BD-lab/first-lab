package bd.laboratory.firstlaboratory.modules.examinationResult

import bd.laboratory.firstlaboratory.modules.order.OrderDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/examinations")
class ExaminationResultController(
        private val examinationResultService: ExaminationResultService
) {
    @PostMapping("/order")
    fun getAllResultsForOrder(@RequestBody orderNumber: String): List<ExaminationResultDTO> =
            examinationResultService.getAllResultsForOrder(orderNumber)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addExaminations(@RequestBody orderDTO: OrderDTO) =
            examinationResultService.addExaminations(orderDTO)

    @PutMapping("/{examinationResultId}")
    fun updatePatientValue(
            @PathVariable examinationResultId: Int,
            @RequestParam(name = "patientValue") patientValue: Double
    ): ExaminationResultDTO = examinationResultService.updatePatientValue(examinationResultId, patientValue)
}