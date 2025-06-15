import { Directive, HostBinding, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[appCampoColorido]',
})
export class CampoColoridoDirective {
  @Input('appCampoColorido') cor: string = 'gray';

  @HostBinding('style.backgroundColor') corDeFundo?: string;

  @HostListener('focus') aoGanharFoco() {
    this.corDeFundo = this.cor;
  }

  @HostListener('blur') aoPerderFoco() {
    this.corDeFundo = 'transparent';
  }
}
