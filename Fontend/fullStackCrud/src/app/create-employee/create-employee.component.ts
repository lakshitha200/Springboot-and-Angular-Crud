import { Component } from '@angular/core';
import { Employee } from '../Model/Employee';
import { EmployeeService } from '../Service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css'
})
export class CreateEmployeeComponent {

  constructor(private employeeService:EmployeeService,private router:Router){}

  employee: Employee = new Employee();


  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data=>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error))
  }

  goToEmployeeList(){
    this.router.navigateByUrl('employees');
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}
