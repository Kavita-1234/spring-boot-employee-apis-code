package emp.example.emp.Controller;

import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Empl> createEmpl(@RequestBody List<Empl> empl) {
    	return emplService.createEmpl(empl);
        
    }

    // Read
    @GetMapping("/get-emp")
    public ResponseEntity<List<Empl>> getEmpl() {
        System.out.println("Get all employees details.");
        return ResponseEntity.ok(emplService.getEmpl());
    }
    

    // Update
    @PutMapping("/update-emp/{id}")
    public ResponseEntity<Empl> updateEmpl(@PathVariable Long id, @RequestBody Empl empl) {
        Empl updatedEmpl = emplService.updateEmpl(id, empl);
        return ResponseEntity.ok(updatedEmpl);
    }

    // Delete employee details
    @DeleteMapping("/delete-emp/{id}")
    public ResponseEntity<String> deleteEmpl(@PathVariable long id) {
        emplService.deleteEmpl(id);
        return ResponseEntity.ok("Employee details deleted successfully with id: " + id);
    }
    
    // Find name by stream api filter
    @GetMapping("/stream-filter-name")
    public ResponseEntity<List<Empl>> findByName(
    		@RequestParam(required = false) String name){
    	return ResponseEntity.ok(emplService.findByName(name));
    }
   
    //Find salary by stream api filter
    @GetMapping("/stream-filter-salary")
    public ResponseEntity<List<Empl>> findByStreamSalary(
    		@RequestParam(required = false) Integer minSalary,
    		@RequestParam(required = false) Integer maxSalary){
    	return ResponseEntity.ok(emplService.findByStreamSalary(minSalary, maxSalary));
    }
    
    // find name by jpa repository 
    @GetMapping("/jpa-repo-name")
    public ResponseEntity<List<Empl>> findByJpaRepoName(
    		@RequestParam(required = false) String name){
    	return ResponseEntity.ok(emplService.findByJpaRepoName(name));
    }
    
    //find salary by jpa repository
    @GetMapping("/jpa-repo-salary")
    public ResponseEntity<List<Empl>> findByJpaRepoSalary(
    		@RequestParam(required = false) Integer minSalary,
    		@RequestParam(required = false) Integer maxSalary){
    	return ResponseEntity.ok(emplService.findByJpaRepoSalary(minSalary, maxSalary));
    }
    
}
