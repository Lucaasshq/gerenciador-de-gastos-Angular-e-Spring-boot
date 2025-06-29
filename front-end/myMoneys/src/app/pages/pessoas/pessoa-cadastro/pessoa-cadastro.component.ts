import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputMaskModule } from 'primeng/inputmask';
import { FormsModule } from '@angular/forms';
import { MessageComponent } from "../../../shared/message/message.component";

@Component({
  selector: 'app-pessoa-cadastro',
  imports: [FormsModule, ButtonModule, InputTextModule, InputMaskModule, RouterLink, MessageComponent],
  templateUrl: './pessoa-cadastro.component.html',
  styleUrl: './pessoa-cadastro.component.css'
})
export class PessoaCadastroComponent {

}
