package bd.laboratory.firstlaboratory

import org.springframework.stereotype.Service

@Service
class PatientService(
        private val patientRepository: PatientRepository
) {

    fun addPatient(patient: PatientDTO): PatientDTO {
        return PatientDTO(patientRepository.save(patient.toPatientEntity()))
    }
}