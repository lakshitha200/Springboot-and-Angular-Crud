import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../Service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../Model/Employee';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent implements OnInit{

  constructor(private employeeService:EmployeeService,
              private activateRoute:ActivatedRoute,
              private router:Router){ }
  
  id!:number;         
  employee: Employee = new Employee();

  ngOnInit(): void {
    this.id = this.activateRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data =>{
      this.employee = data;
    })
  }

  onSubmit(){
  
    const userConfirmd = window.confirm("Are you want to Update?");
    console.log(userConfirmd);

    if(userConfirmd){
      this.employeeService.updateEmployee(this.id,this.employee).subscribe(data => {
        this.goToEmployeeList();
        alert("Successfully Updated.")
      })
    }else{
      console.log("Not Updated")
    }
    
  }
  goToEmployeeList(){
    this.router.navigateByUrl('/employees');
  }

}
