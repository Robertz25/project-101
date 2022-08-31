package no.acntech.project101.web.employee.resources;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@CrossOrigin(origins = "http://localhost:3000")
@RestController@RequestMapping("employees")
public class EmployeeResource {
    public EmployeeResource() {
    }
    @GetMapping    public ResponseEntity<List<EmployeeDto>> findAll() {
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable final Long id) {
        final var employee1 = new EmployeeDto(1L, "Ørjan", "Johansen", LocalDate.of(1985, 1, 24), 1L);
        return ResponseEntity.ok(employee1);
    }
    @PostMapping    public ResponseEntity createEmployee(@RequestBody @Validated final EmployeeDto employeeDto) {
        final var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(1L)
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteEmployee(@PathVariable final Long id) {
        return ResponseEntity.accepted().build();
    }
    @PatchMapping("{id}")
    public ResponseEntity updateEmployee(@PathVariable final Long id, @RequestBody final EmployeeDto employeeDto) {
        return ResponseEntity.ok().build();
    }
}