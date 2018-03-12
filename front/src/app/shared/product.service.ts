import { Injectable } from '@angular/core';
import { Product, Image } from './types';

@Injectable()
export class ProductService {

  getProducts(): Product[] {
    return products;
  }

  getProductById(productId: number): Product {
    return products.find(p => p.id === productId);
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


