package emp.example.emp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emp.example.emp.Entity.Empl;
import emp.example.emp.Service.EmplService;

@RestController
@RequestMapping("/emp-data")
public class EmplController {

    private final EmplService emplService;

    public EmplController(EmplService emplService) {
        this.emplService = emplService;
    }

    // Create
    @PostMapping("/create-emp")
    public ResponseEntity<?> createEmpl(@RequestBody List<Empl> empl) {
        try {
            return ResponseEntity.ok(emplService.createEmpl(empl));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while creating employee: " + e.getMessage());
        }
    }

    // Read
    @GetMapping("/get-emp")
    public ResponseEntity<?> getEmpl() {
        try {
            System.out.println("Get all employees details.");
            return ResponseEntity.ok(emplService.getEmpl());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while fetching employees: " + e.getMessage());
        }
    }

    // Update
    @PutMapping("/update-emp/{id}")
    public ResponseEntity<?> updateEmpl(@PathVariable Long id, @RequestBody Empl empl) {
        try {
            Empl updatedEmpl = emplService.updateEmpl(id, empl);
            return ResponseEntity.ok(updatedEmpl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while updating employee: " + e.getMessage());
        }
    }

    // Delete
    @DeleteMapping("/delete-emp/{id}")
    public ResponseEntity<?> deleteEmpl(@PathVariable long id) {
        try {
            emplService.deleteEmpl(id);
            return ResponseEntity.ok("Employee details deleted successfully with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while deleting employee: " + e.getMessage());
        }
    }

    // Find by name (stream filter)
    @GetMapping("/stream-filter-name")
    public ResponseEntity<?> findByName(@RequestParam(required = false) String name) {
        try {
            System.out.println("Get employees details by apply stream api filter");
            return ResponseEntity.ok(emplService.findByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while filtering by name: " + e.getMessage());
        }
    }

    // Find by salary (stream filter)
    @GetMapping("/stream-filter-salary")
    public ResponseEntity<?> findByStreamSalary(
            @RequestParam(required = false) Integer minSalary,
            @RequestParam(required = false) Integer maxSalary) {
        try {
            return ResponseEntity.ok(emplService.findByStreamSalary(minSalary, maxSalary));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while filtering by salary: " + e.getMessage());
        }
    }

    // Find by name (JPA repository)
    @GetMapping("/jpa-repo-name")
    public ResponseEntity<?> findByJpaRepoName(@RequestParam(required = false) String name) {
        try {
            System.out.println("Get employees name by apply jpa repository filter");
            return ResponseEntity.ok(emplService.findByJpaRepoName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while fetching name by JPA repo: " + e.getMessage());
        }
    }

    // Find by salary (JPA repository)
    @GetMapping("/jpa-repo-salary")
    public ResponseEntity<?> findByJpaRepoSalary(
            @RequestParam(required = false) Integer minSalary,
            @RequestParam(required = false) Integer maxSalary) {
        try {
            System.out.println("Get employees salary by apply jpa repository filter");
            return ResponseEntity.ok(emplService.findByJpaRepoSalary(minSalary, maxSalary));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while fetching salary by JPA repo: " + e.getMessage());
        }
    }
}
