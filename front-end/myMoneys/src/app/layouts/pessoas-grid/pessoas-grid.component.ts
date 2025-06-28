import { Component, Input } from '@angular/core';
import { Pessoa } from '../../Model/pessoas';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-pessoas-grid',
  imports: [ButtonModule, TableModule, CommonModule],
  templateUrl: './pessoas-grid.component.html',
  styleUrl: './pessoas-grid.component.css'
})
export class PessoasGridComponent {
  @Input() pessoas!: Pessoa[];

}
