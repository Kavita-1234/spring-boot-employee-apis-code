package emp.example.emp.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import emp.example.emp.Entity.Empl;
import emp.example.emp.Repository.EmplRepository;

@Service
public class EmplService {

    private final EmplRepository emplRepository;

    public EmplService(EmplRepository emplRepository) {
        this.emplRepository = emplRepository;
    }

    // Create
    public List<Empl> createEmpl(List<Empl> empl) {
        return emplRepository.saveAll(empl);
    }

    // Read
    public List<Empl> getEmpl() {
        return emplRepository.findAll();
    }

    // Update
    public Empl updateEmpl(long id, Empl empl) {
    	return emplRepository.findById(id)
                .map(existingEmpl -> {
                    existingEmpl.setName(empl.getName());
                    existingEmpl.setRole(empl.getRole());
                    existingEmpl.setSalary(empl.getSalary());
                    return emplRepository.save(existingEmpl);
                })
                .orElseGet(() ->{
                return emplRepository.save(empl);
                });
    }


    // Delete
    public void deleteEmpl(long id) {
        emplRepository.deleteById(id);
    }
    
     
    //Stream API filter by name
    public List<Empl> findByName(String name){
    	return emplRepository.findAll().stream()
                .filter(empl -> (name == null || empl.getName().toUpperCase().startsWith(name.toUpperCase())))
                .collect(Collectors.toList());
    }
    
    // Stream API filter by salary
    public List<Empl> findByStreamSalary(Integer minSalary, Integer maxSalary){
    	return emplRepository.findAll().stream()
                .filter(empl -> (minSalary == null || empl.getSalary() >= minSalary))
                .filter(empl -> (maxSalary == null || empl.getSalary() <= maxSalary))
                .collect(Collectors.toList());
    }
    
    //Filter by jpa repository find name
    public List<Empl> findByJpaRepoName(String name){
    	if(name == null || name.isEmpty()) {
    		return emplRepository.findAll();
    	}
    	return emplRepository.findByNameStartingWithIgnoreCase(name);
    }
    
    //Filter by jpa repository find salary
    public List<Empl> findByJpaRepoSalary(Integer minSalary, Integer maxSalary){
    	if(minSalary == null && maxSalary == null) {
    		return emplRepository.findAll();
    	}
    	return emplRepository.findBySalaryBetween(minSalary, maxSalary);
    	
    }
}
