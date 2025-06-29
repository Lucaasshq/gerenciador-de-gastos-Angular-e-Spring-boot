import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import {  NgModel } from '@angular/forms';

@Component({
  selector: 'app-message',
  template: `
     <div class="error-message" *ngIf="temError()" >
            {{text}}
      </div>
          `,
  imports: [CommonModule],
   styleUrl: './message.component.css'
})
export class MessageComponent {


  @Input() error!: string;
  @Input() control!: NgModel;
  @Input() text!: string;

  temError(): boolean {
    return (this.control.errors?.[this.error] ?? false) && this.control.touched
  }
}
