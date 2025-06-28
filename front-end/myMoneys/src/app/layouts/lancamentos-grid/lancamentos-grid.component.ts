import { Component } from '@angular/core';

import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { Lancamento } from '../../Model/Lancamentos';
import { CommonModule } from '@angular/common';
import { Input } from '@angular/core';

@Component({
  selector: 'app-lancamentos-grid',
  imports: [TableModule, ButtonModule, CommonModule],
  templateUrl: './lancamentos-grid.component.html',
  styleUrl: './lancamentos-grid.component.css'
})
export class LancamentosGridComponent {

 @Input() lancamentos!: Lancamento[];

}
