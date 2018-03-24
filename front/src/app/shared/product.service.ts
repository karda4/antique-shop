import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { API, Product, Image } from './types';

@Injectable()
export class ProductService {

  constructor(private httpClient: HttpClient) { }
    
  getProducts(): Product[] {
    let products: Product[] = [];

    this.httpClient.get<Product[]>(API + '/products')
      .subscribe(
        data => {
            console.log('Products: ' + data);
            products.push(...data)
        },
        (err: HttpErrorResponse) => console.log(err)
      );

    return products;
  }

  getProductById(productId: number): Product {
    let product: Product = <Product> {};

    this.httpClient.get<Product>(API + `/products/${productId}`)
      .subscribe(
        data => Object.assign(product, data),
        err => console.log(err)
      );

    return product;
  }
}
