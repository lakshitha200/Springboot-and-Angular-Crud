package fullstackCrud.com.fullStackCrud.Controller;
import fullstackCrud.com.fullStackCrud.Model.Employee;
import fullstackCrud.com.fullStackCrud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Get all employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    //Create employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    //Get Employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeByID(id), HttpStatus.OK);
    }

    //Update Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(id,employee),HttpStatus.OK);
    }

    //delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        return new ResponseEntity<Map<String,Boolean>>(employeeService.deleteEmployee(id),HttpStatus.OK);
    }
}
