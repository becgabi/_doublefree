import {Component} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Menu, MENU_ITEMS} from "../../util/menu.util";

@Component({
  selector: 'app-frame',
  templateUrl: './frame.component.html',
  styleUrls: ['./frame.component.scss']
})
export class FrameComponent {

  menu: Menu[] = MENU_ITEMS;

  constructor(public authService: AuthService) {
  }
}
