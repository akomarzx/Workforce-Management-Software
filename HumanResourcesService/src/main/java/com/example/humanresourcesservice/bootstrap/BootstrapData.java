package com.example.humanresourcesservice.bootstrap;

import com.example.humanresourcesservice.domain.Company;
import com.example.humanresourcesservice.domain.Department;
import com.example.humanresourcesservice.domain.Employee;
import com.example.humanresourcesservice.enums.Sex;
import com.example.humanresourcesservice.repository.CompanyRepository;
import com.example.humanresourcesservice.repository.DepartmentRepository;
import com.example.humanresourcesservice.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class BootstrapData implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    private final DepartmentRepository departmentRepository;

    public BootstrapData(EmployeeRepository employeeRepository, CompanyRepository companyRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        Company c1 = new Company();
//        c1.setCompanyName("Company Test 1");
//        c1.setCreatedDate(LocalDate.now());
//        c1.setCreatedBy("Ronald Test");
//        this.companyRepository.save(c1);
//
//        Company c2 = new Company();
//        c2.setCompanyName("Company Test 2");
//        c2.setCreatedDate(LocalDate.now());
//        c2.setCreatedBy("Ronald Test");
//        this.companyRepository.save(c2);
//
//        Department d1 = new Department();
//        d1.setDepartmentName("Management Company 1");
//        d1.setCompany(c1);
//        d1.setCreatedBy("Ronald Test");
//        this.departmentRepository.save(d1);
//
//        Department d2 = new Department();
//        d2.setDepartmentName("Management");
//        d2.setCompany(c2);
//        d2.setCreatedBy("Ronald Test");
//        this.departmentRepository.save(d2);
//
//        Employee e1 = new Employee();
//        e1.setCreatedBy("RonaldTest");
//        e1.setFirstName("Ronald");
//        e1.setLastName("Ombao");
//        e1.setBirthDate(LocalDate.of(1997, 4, 12));
//        e1.setHiringDate(LocalDate.of(2023, 3, 22));
//        e1.setSex(Sex.MALE);
//        e1.setDepartment(d1);
//        this.employeeRepository.save(e1);
//
//        Employee e2 = new Employee();
//        e2.setCreatedBy("RonaldTest");
//        e2.setFirstName("Rebekah");
//        e2.setLastName("Ombao");
//        e2.setBirthDate(LocalDate.of(1997, 6, 8));
//        e2.setHiringDate(LocalDate.of(2023, 3, 22));
//        e2.setSex(Sex.FEMALE);
//        e2.setDepartment(d1);
//        this.employeeRepository.save(e2);
//
//        Employee e3 = new Employee();
//        e2.setCreatedBy("RonaldTest");
//        e2.setFirstName("Jewel");
//        e2.setLastName("Ombao");
//        e2.setBirthDate(LocalDate.of(2014, 3, 2));
//        e2.setHiringDate(LocalDate.of(2023, 3, 22));
//        e2.setSex(Sex.FEMALE);
//        e2.setDepartment(d1);
//        this.employeeRepository.save(e2);


        Optional<Department> dept1 = this.departmentRepository.findById(100L);
        dept1.get().getEmployeeList().remove(0);
        this.departmentRepository.save(dept1.get());

    }
}
