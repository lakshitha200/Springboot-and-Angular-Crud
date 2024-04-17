package fullstackCrud.com.fullStackCrud.Service;
import fullstackCrud.com.fullStackCrud.Model.Employee;



import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeByID(long id);
    public Employee updateEmployee(Long id,Employee employee);
    public Map<String,Boolean> deleteEmployee(Long id);
}
