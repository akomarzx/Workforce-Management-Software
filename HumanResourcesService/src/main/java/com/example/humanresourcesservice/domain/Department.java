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
@Table(name = "department", indexes = {
        @Index(name = "company_pk_index", columnList = "company_pk")
})
@Getter
@Setter
@ToString
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_gen")
    @SequenceGenerator(name = "dept_gen", sequenceName = "dept_pk_seq", initialValue = 100)
    @Column(name = "department_pk", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long departmentPk;

    @Column(name = "department_name")
    @NotNull
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_pk", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

    public void addEmployee(Employee employee) {
        employee.setDepartment(this);
        this.employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employee.setDepartment(null);
        this.employeeList.remove(employee);
    }
}
