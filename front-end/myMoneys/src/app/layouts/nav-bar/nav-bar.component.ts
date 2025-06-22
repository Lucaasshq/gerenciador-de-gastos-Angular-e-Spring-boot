import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { RouterModule, RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-nav-bar',
  imports: [ButtonModule, RouterModule, CommonModule],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css',
})
export class NavBarComponent {
 menuAberto = false;

alternarMenu() {
  this.menuAberto = !this.menuAberto;
}
}
