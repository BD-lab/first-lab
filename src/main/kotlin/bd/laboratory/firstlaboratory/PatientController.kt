package bd.laboratory.firstlaboratory

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/patients")
class PatientController(
        private val patientService: PatientService
) {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun addPatient(@Valid @RequestBody patient: PatientDTO): PatientDTO {
        return patientService.addPatient(patient)
    }
}