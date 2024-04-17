package fullstackCrud.com.fullStackCrud.Repository;

import fullstackCrud.com.fullStackCrud.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //crud
}
