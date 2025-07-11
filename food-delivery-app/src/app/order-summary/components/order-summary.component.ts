import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../service/order.service';
import { OrderDTO } from '../models/OrderDTO';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.scss'],
  imports: [CommonModule]
})
export class OrderSummaryComponent {

  orderSummary?: OrderDTO;
  obj: any;
  total?: any;
  showDialog: boolean = false;

  constructor(private route: ActivatedRoute, private orderService: OrderService, private router: Router) { }
  
ngOnInit() {
  const data = this.route.snapshot.queryParams['data'];
  this.obj = JSON.parse(data);
  this.obj.userId = 1;
  this.orderSummary = this.obj;

  this.total = this.orderSummary?.foodItemsList?.reduce((accumulator: number, currentValue: any) => {
    const quantity = currentValue.quantity ?? 0;
    const price = currentValue.price ?? 0;
    return accumulator + (quantity * price);
  }, 0) ?? 0;
}

  save() {
    this.orderService.save(this.orderSummary)
      .subscribe(
        response => {
            this.showDialog = true;
        },
        error => {
          console.error('Failed to save data:', error);
        }
      );
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']);
  }
}
