import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'pipes';

  nome:string = "Lucas";
  dataAniversario:Date = new Date(2004, 1, 26);
  preco:number = 12855.32;
  troco:number = 0.573992;
}
