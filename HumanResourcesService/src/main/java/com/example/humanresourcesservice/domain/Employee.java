package com.example.humanresourcesservice.domain;

import com.example.humanresourcesservice.enums.Sex;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Setter
@Getter
@ToString(callSuper = true)
public class Employee extends BaseEntity {
    //TODO This behavior will be moved over to the business logic layer for Better SOC.
    @PrePersist
    protected void onCreate() {
        setEmployeeId(RandomStringUtils.randomAlphanumeric(12));
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", initialValue = 3000)
    @Column(name = "employee_pk", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long employee_pk;

    @NotNull
    @Column(name = "employee_id", unique = true)
    private String employeeId;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "birth_date")
    @Temporal(value = TemporalType.DATE)
    private LocalDate birthDate;

    @NotNull
    @Column(name = "hiring_date")
    @Temporal(value = TemporalType.DATE)
    private LocalDate hiringDate;

    @NotNull
    @Column(columnDefinition = "integer CHECK (sex IN (1 ,2, 9, 0))")
    private Sex sex;
}