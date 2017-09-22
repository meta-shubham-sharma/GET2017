import { Injectable } from '@angular/core';
import { Products } from './Products';
import { PRODUCTS } from './mock-products';

@Injectable ()
export class ProductService {
getProducts(): Promise<Products[]> {
return Promise.resolve(PRODUCTS);
}
}
