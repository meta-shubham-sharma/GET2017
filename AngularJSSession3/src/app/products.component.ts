import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Product } from './product';
import { ProductService } from './product.service';

@Component({
    selector: 'my-products',
    templateUrl: './products.component.html',
    styleUrls: [ './products.component.css' ]
  })

  export class ProductsComponent implements OnInit {
      products: Product[];
      selectedProduct: Product;

      constructor(
        private productService: ProductService,
        private router: Router) { }

      getProducts(): void {
        this.productService
            .getProducts()
            .then(products => this.products = products.slice(1));
      }

      delete(product: Product): void {
        if ( confirm ('Are you sure to delete the product : ' + product.name )) {
        this.productService
            .delete(product.id)
            .then(() => {
              this.products = this.products.filter(h => h !== product);
              if (this.selectedProduct === product) { this.selectedProduct = null; }
            });
          }
      }

      ngOnInit(): void {
        this.getProducts();
      }

      onSelect(product: Product): void {
        this.selectedProduct = product;
      }

      gotoDetail(): void {
        this.router.navigate(['/detail', this.selectedProduct.id]);
      }

      gotoAddProduct(): void {
        this.router.navigate(['/addProduct']);
      }

      getProductDetail(): void {
        this.router.navigate(['/getProductDetail', this.selectedProduct.id]);
      }
}
