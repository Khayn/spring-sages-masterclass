import {Component} from '@angular/core';
import {PagedResultModel} from "../../model/paged-result.model";
import {ProductService} from "../../service/product.service";
import {ProductModel} from "../../model/product.model";

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent {

  pagedResult: PagedResultModel<ProductModel> = new PagedResultModel<ProductModel>();

  constructor(private productService: ProductService) {
    this.reload(0);
  }

  previous() {
    this.reload(this.pagedResult.pageNumber - 1);
  }

  next() {
    this.reload(this.pagedResult.pageNumber + 1);
  }

  private reload(pageNumber: number) {
    this.productService.getProducts(pageNumber)
      .subscribe(pagedResult => this.pagedResult = pagedResult, error => console.log(error));
  }

}
