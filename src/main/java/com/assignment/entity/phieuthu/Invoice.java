package com.assignment.entity.phieuthu;

import com.assignment.entity.mamnon.Student;
import lombok.*;
import lombok.Builder.Default;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_invoice")
@NamedQueries({
		@NamedQuery(name = Invoice.FIND_BY_MONTH_YEAR_CLASSID_AND_FETCH_TUITIONS, query = "select distinct i from Invoice i " +
				"left join fetch i.tuitions where i.month = ?1 and i.year = ?2 and i.student.clazz.id = ?3"),
		@NamedQuery(name = Invoice.FIND_BY_MONTH_YEAR_CLASSID_STUDENTID_IN_AND_FETCH_TUITIONS, query = "select distinct i from Invoice i " +
				"left join fetch i.tuitions where i.month = ?1 and i.year = ?2 and i.student.clazz.id = ?3 and i.student.id in (?4)") }
)
@NamedEntityGraph(
		name = "invoice-tuitions-graph",
		attributeNodes = {
				@NamedAttributeNode("tuitions")
		}
)
public class Invoice {

	public static final String FIND_BY_MONTH_YEAR_CLASSID_AND_FETCH_TUITIONS = "Invoice.findByMonthAndYearAndStudentClazzIdAndFetchTuitions";
	public static final String FIND_BY_MONTH_YEAR_CLASSID_STUDENTID_IN_AND_FETCH_TUITIONS = "Invoice.findByMonthAndYearAndStudentClazzIdAndStudentIdInAndFetchTuitions";

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private int month;

	@NotNull
	private int year;

	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer totalAmount = 0;

	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer paymentAmount = 0;

	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer remainAmount = 0;

	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer kDaysPrevMonth = 0;

	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer pDaysPrevMonth = 0;

	@Builder.Default
	@Column(nullable = false, columnDefinition = "int default 0")
	private Integer daysToClassCurrentMonth = 0;

	@NotNull
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Tuition> tuitions = new ArrayList<>();

	@Default
	private Boolean isPaid = false;

	private Integer truyThuAmount;
	// if the year and month is equal to the invoice, tuitions will transfer to thumamnon from 1 to 7
	// else will update the total amount that mapped to the above truyThuAmount
	private LocalDate paidDate;

	@UpdateTimestamp
	private LocalDateTime createdTime;

	@NotNull
	private Integer schoolId;
	private Integer stt;

	private String note;

	public void addTuitions(List<Tuition> tuitions) {
		for(Tuition tuition: tuitions) {
			tuition.setInvoice(this);
			this.tuitions.add(tuition);
			this.totalAmount += tuition.getAmount();
		}
	}

}
