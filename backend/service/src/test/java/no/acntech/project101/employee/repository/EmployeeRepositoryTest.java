package no.acntech.project101.employee.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import no.acntech.project101.company.config.CompanyDatabaseConfig;
import no.acntech.project101.employee.Employee;
import no.acntech.project101.employee.config.EmployeeDatabaseConfig;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import({EmployeeDatabaseConfig.class, CompanyDatabaseConfig.class})
@ContextConfiguration(classes = EmployeeRepository.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void save() {
        final var employee = new Employee();
                final var savedEmployee = employeeRepository.save(employee);
                assertThat(savedEmployee.getId()).isNotNull();
                assertThat(savedEmployee.getFirstname()).isEqualTo(employee.getFirstname());
                assertThat(savedEmployee.getLastname()).isEqualTo(employee.getLastname());
                assertThat(savedEmployee.getDate_of_birth()).isEqualTo(employee.getDate_of_birth());
                assertThat(savedEmployee.getCompanyId()).isEqualTo(employee.getCompanyId());
    }
}
