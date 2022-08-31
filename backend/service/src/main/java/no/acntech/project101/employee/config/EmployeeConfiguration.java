package no.acntech.project101.employee.config;

import jakarta.persistence.Column;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "no.acntech.project101.employee")
public class EmployeeConfiguration {
}
