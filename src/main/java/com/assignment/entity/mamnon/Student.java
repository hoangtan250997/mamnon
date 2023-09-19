package com.assignment.entity.mamnon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id", "createdDate", "modifiedDate"})
@Table(name = "mn_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // old student id when transferring this student to new class
    private Integer legacyStudentId;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer stt = 0;

    @NotNull
	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
    private String firstName;
    
    @Size(max = 300)
	@Column(length = 300)
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate entryDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Size(max = 100)
   	@Column(length = 100)
    private String fatherPhone;
  
    @Size(max = 300)
   	@Column(length = 300)
    private String fatherName;
    
    @Size(max = 100)
   	@Column(length = 100)
    private String motherPhone;
   
    @Size(max = 300)
   	@Column(length = 300)
    private String motherName;

    @CreationTimestamp
    private LocalDateTime createdDate;
    
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Absence> absences = new ArrayList<>();

    @Builder.Default
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive = true;

    public void addAbsence(Absence absence) {
        absences.add(absence);
        absence.setStudent(this);
    }

    public void addAbsenses(List<Absence> absences) {
        if (absences != null) {
            this.absences.addAll(absences);
        }
    }

    public void removeAbsence(Absence absence) {
        absences.remove(absence);
        absence.setStudent(null);
    }

    public void removeAbsences(List<Absence> absences) {
        this.absences.removeAll(absences);
        for (Absence absence : absences) {
            absence.setStudent(null);
        }
    }

    public String getFullName() {
        return this.getLastName() + " " + this.getFirstName();
    }
}
