package com.example.humanresourcesservice.bootstrap;

import com.example.humanresourcesservice.domain.Company;
import com.example.humanresourcesservice.domain.Employee;
import com.example.humanresourcesservice.enums.Sex;
import com.example.humanresourcesservice.repository.CompanyRepository;
import com.example.humanresourcesservice.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class BootstrapData implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public BootstrapData(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Company c1 = new Company();
        c1.setCompanyName("Company Test 1");
        c1.setCreatedDate(LocalDate.now());
        c1.setCreatedBy("Ronald Test");
        this.companyRepository.save(c1);

        Company c2 = new Company();
        c2.setCompanyName("Company Test 2");
        c2.setCreatedDate(LocalDate.now());
        c2.setCreatedBy("Ronald Test");
        this.companyRepository.save(c2);

        Employee e1 = new Employee();
        e1.setCreatedBy("RonaldTest");
        e1.setFirstName("Ronald");
        e1.setLastName("Ombao");
        e1.setBirthDate(LocalDate.of(1997, 4, 12));
        e1.setHiringDate(LocalDate.of(2023, 3, 22));
        e1.setSex(Sex.MALE);
        e1.setCompany(c1);
        this.employeeRepository.save(e1);

        Employee e2 = new Employee();
        e2.setCreatedBy("RonaldTest");
        e2.setFirstName("Rebekah");
        e2.setLastName("Ombao");
        e2.setBirthDate(LocalDate.of(1997, 6, 8));
        e2.setHiringDate(LocalDate.of(2023, 3, 22));
        e2.setSex(Sex.FEMALE);
        e2.setCompany(c2);
        this.employeeRepository.save(e2);

        Optional<Employee> e3 = this.employeeRepository.findById(3001L);

        e3.ifPresent(System.out::println);
    }
}
