import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
  
  private baseUrl = 'https://8080-grecotan12-fullstackeco-lkahhatu5a3.ws-us117.gitpod.io/api/products';
  
  private categoryUrl = 'https://8080-grecotan12-fullstackeco-lkahhatu5a3.ws-us117.gitpod.io/api/product-category';
  
  constructor(private httpClient: HttpClient) { }
  
  getProduct(theProductId: number): Observable<Product> {
    // need to build URL based on product id
    const productUrl = `${this.baseUrl}/${theProductId}`;

    return this.httpClient.get<Product>(productUrl);
  }

  getProductList(theCategoryId: number): Observable<Product[]> {
    
    // @TODO: need to buil URL based on category id ... will come back to this!
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;
    
    return this.getProducts(searchUrl);
  }
  
  searchProducts(theKeyword: string): Observable<Product[]> {
    // @TODO: need to buil URL based on category id ... will come back to this!
    const searchUrl = `${this.baseUrl}/search/findByNameContaining?name=${theKeyword}`;
    
    return this.getProducts(searchUrl);
  }
  

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productCategory)
    );
  }
  
  private getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<GetResponseProducts>(searchUrl).pipe(
      map(response => response._embedded.products)
    );
  }
}

interface GetResponseProducts {
  _embedded: {
    products: Product[];
  }
}

interface GetResponseProductCategory {
  _embedded: {
    productCategory: ProductCategory[];
  }
}
