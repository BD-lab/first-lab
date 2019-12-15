package bd.laboratory.firstlaboratory.modules.examinationResult

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ExaminationResultRepository : JpaRepository<ExaminationResult, Int> {
    fun findAllByOrderNumber(orderNumber: String): List<ExaminationResult>

    @Query("""
        SELECT DISTINCT e.order_number FROM examination_result e
    """, nativeQuery = true
    )
    fun findDistinctOrderNumbers(): List<String>
}