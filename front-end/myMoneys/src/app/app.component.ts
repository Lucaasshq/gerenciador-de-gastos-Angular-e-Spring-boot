import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';
import { NavBarComponent } from "./layouts/nav-bar/nav-bar.component";
import { RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-root',
  imports: [
    NavBarComponent,
    RouterOutlet
],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [MessageService],
})
export class AppComponent {

}
