import {Component} from '@angular/core';
import {UserService} from "../../service/user.service";
import {Router} from "@angular/router";
import {UserModel} from "../../model/user.model";

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  user = new UserModel();

  constructor(private userService: UserService, private router: Router) {
  }


  save() {
    this.userService.addUser(this.user).subscribe(() => this.router.navigateByUrl('users'), error => console.log(error));
  }
}
