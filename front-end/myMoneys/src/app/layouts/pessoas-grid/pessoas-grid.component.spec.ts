import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoasGridComponent } from './pessoas-grid.component';

describe('PessoasGridComponent', () => {
  let component: PessoasGridComponent;
  let fixture: ComponentFixture<PessoasGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PessoasGridComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PessoasGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
