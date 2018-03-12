import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product, Image } from './types';

@Injectable()
export class ProductService {

  constructor(private httpClient: HttpClient) { }
    
  getProducts(): Product[] {
    const products: Product[] = [];

    this.httpClient.get<Product[]>("/api/products")
      .subscribe(
        data => products.push(...data),
        err => console.log(err)
      );

    return products;
    //return products;
  }

  getProductById(productId: number): Product {
      let product: Product = <Product> {};

    this.httpClient.get<Product>(`/api/products/${productId}`)
      .subscribe(
        data => Object.assign(product, data),
        err => console.log(err)
      );

    return product;
    //return products.find(p => p.id === productId);
  }
}

const categoryFirst = {
    "id": 1,
    "name": "First Category"
};
const categorySecond = {
    "id": 2,
    "name": "Second Category"
};

const image1: Image = {
    id: 1,
    path: "image1"
}

const products: Array<Product> = [
  {
    id: 0,
    name: "First Product",
    price: 24,
    description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    category: categoryFirst,
    image: image1
  },
  {
    id: 1,
    name: "Second Product",
    price: 64,
    description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    category: categoryFirst,
    image: image1
  },
  {
    id: 2,
    name: "Third Product",
    price: 74,
    description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    category: categorySecond,
    image: image1
  }
];


