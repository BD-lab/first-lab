package bd.laboratory.firstlaboratory

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientRepository : JpaRepository<Patient, Int>