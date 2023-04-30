package com.example.humanresourcesservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Table(name = "company", indexes = @Index(columnList = "company_pk"))
@Getter
@Setter
public class Company extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "company_gen", sequenceName = "company_seq", initialValue = 100)
    @Column(name = "company_pk", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long companyPk;

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Employee> companyEmployees;
}
