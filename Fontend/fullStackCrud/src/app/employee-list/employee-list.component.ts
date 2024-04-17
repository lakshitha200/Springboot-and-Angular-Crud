import { Component} from '@angular/core';
import { Employee } from '../Model/Employee';
import { EmployeeService } from '../Service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent {

  employees: Employee[] = [];

  constructor(private employeeService:EmployeeService,private router:Router){}
  

  ngOnInit():void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeeList().subscribe(data =>{
      this.employees = data;
    });
  }

  updateEmployee(id:number){
    this.router.navigate(["update-employee",id]);
  }
  deleteEmployee(id:number){
    const userConfirmd = window.confirm("Are you want to delete?");
    console.log(userConfirmd);

    if(userConfirmd){
      this.employeeService.deleteEmployee(id).subscribe(data => {
        console.log(data);
        this.getEmployees();
        alert("Successfully Deleted.")
      })
      console.log("Deleted");
    }else{
      console.log("Not Deleted")
    }
    
  }
}
