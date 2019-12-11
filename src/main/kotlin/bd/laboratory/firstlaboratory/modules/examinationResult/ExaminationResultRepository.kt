package bd.laboratory.firstlaboratory.modules.examinationResult

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExaminationResultRepository : JpaRepository<ExaminationResult, Int>