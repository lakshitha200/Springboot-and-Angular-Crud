import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'fullStackCrud';

  clicked(){
    const userConfirmd = window.confirm("Are you want to delete?");
    console.log(userConfirmd);

    if(userConfirmd){
      console.log("Deleted");
    }else{
      console.log("Not Deleted")
    }
  }
  
  
}
