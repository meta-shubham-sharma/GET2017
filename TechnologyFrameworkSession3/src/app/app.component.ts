import { Component, OnInit } from '@angular/core';
import { Products } from './Products';
import { PRODUCTS } from './mock-products';
import { ProductService } from './products.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Products';
  products = PRODUCTS;
  constructor(private productService: ProductService) {}
  ngOnInit() {
  this.getProducts();
  }
  getProducts(): void {
  this.productService.getProducts().then(products => this.products = products);
  }
  }
