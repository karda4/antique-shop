export const API = '/api';

export interface Product {
    id: number;
    name: string;
    price: number;
    description: string;
    category: Category;
    image: Image;
}

export interface Category {
    id: number;
    name: string;
}

export interface Image {
    id: number;
    path: string;
}
