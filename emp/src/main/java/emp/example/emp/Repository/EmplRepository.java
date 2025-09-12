package emp.example.emp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import emp.example.emp.Entity.Empl;
import java.util.List;


@Repository
public interface EmplRepository extends JpaRepository<Empl, Long> {

	
	
	List<Empl> findByNameStartingWithIgnoreCase(String name);
	
	List<Empl> findBySalaryBetween(Integer minSalary, Integer maxSalary);

	
	
	
	
}
