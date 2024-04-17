package fullstackCrud.com.fullStackCrud.Service.Impl;

import fullstackCrud.com.fullStackCrud.Exception.ResourceNotFoundException;
import fullstackCrud.com.fullStackCrud.Model.Employee;
import fullstackCrud.com.fullStackCrud.Repository.EmployeeRepository;
import fullstackCrud.com.fullStackCrud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    //Get all employee
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    //Create employee
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //Get Employee by id
    @Override
    public Employee getEmployeeByID(long id) {
        Employee exsitingemployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee Not Existing with id: "+id)
        );
        return exsitingemployee;
    }

    //Update Employee
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        //get Employee from db by id
        Employee exsitingemployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee Not Existing with id: "+id)
        );
        exsitingemployee.setFirstName(employee.getFirstName());
        exsitingemployee.setLastName(employee.getLastName());
        exsitingemployee.setEmail(employee.getEmail());
        //save updated Employee object
        Employee updatedEmployee = employeeRepository.save(exsitingemployee);
        return updatedEmployee;
    }

    //delete employee
    @Override
    public Map<String, Boolean> deleteEmployee(Long id) {
        //get student from db by id
        Employee exsitingemployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee Not Existing with id: "+id)
        );
        employeeRepository.delete(exsitingemployee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }
}
