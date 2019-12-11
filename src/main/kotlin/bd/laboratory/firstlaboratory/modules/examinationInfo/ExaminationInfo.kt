package bd.laboratory.firstlaboratory.modules.examinationInfo

import bd.laboratory.firstlaboratory.modules.examinationResult.ExaminationType
import javax.persistence.*

@Entity
class ExaminationInfo(
        @Id
        // Chyba tu nie potrzebujemy @GeneratedValue, żeby id na bazie nie tworzyły nam się same, tylko my wysyłamy tu już z id
        val id: Int? = null,

        val laboratoryId: Int,

        @Enumerated(EnumType.STRING)
        val type: ExaminationType,

        val isDone: Boolean = false
)