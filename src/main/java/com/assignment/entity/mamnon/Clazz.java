package com.assignment.entity.mamnon;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mn_clazz")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NamedQuery(name = Clazz.FIND_BY_ID_AND_FETCH_STUDENTS, query = "select c from Clazz c left join fetch c.students where c.id = ?1")
@Builder
public class Clazz {

    public static final String FIND_BY_ID_AND_FETCH_STUDENTS = "Clazz.findByIdAndFetchStudents";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(length = 500, nullable = false)
    private String className;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ToString.Exclude
    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("firstName asc")
    List<Student> students = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Holiday> holidays = new ArrayList<>();

    @Size(min = 6, max = 8)
    @Column(columnDefinition = "varchar(8) default '123456'", length = 8)
    private String accessCode;

    public void addStudent(Student student) {
        students.add(student);
        student.setClazz(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setClazz(null);
    }

    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
        holiday.setClazz(this);
    }

    public void removeHoliday(Holiday holiday) {
        holidays.remove(holiday);
        holiday.setClazz(null);
    }
}
