import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Api} from "../api";
import {Observable} from "rxjs";
import {PagedResultModel} from "../model/paged-result.model";
import {ProductModel} from "../model/product.model";

@Injectable()
export class ProductService {
  constructor(private httpClient: HttpClient, private api: Api) {
  }

  addProduct(product: ProductModel): Observable<ProductModel> {
    return this.httpClient.post<ProductModel>(this.api.products, product);
  }

  getProducts(pageNumber = 0, pageSize = 5): Observable<PagedResultModel<ProductModel>> {
    const params = {pageNumber: `${pageNumber}`, pageSize: `${pageSize}`};
    return this.httpClient.get<PagedResultModel<ProductModel>>(this.api.products + "/all", {params});
  }
}
