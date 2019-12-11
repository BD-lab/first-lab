package bd.laboratory.firstlaboratory.modules.order

import bd.laboratory.firstlaboratory.modules.examinationInfo.ExaminationInfo
import javax.persistence.*

@Entity
@Table(name = "order_table")
class Order(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,

        @Column(unique = true)
        val orderNumber: String,

        val patientId: Int,

        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn(name = "order_id")
        val examinations: List<ExaminationInfo>
)