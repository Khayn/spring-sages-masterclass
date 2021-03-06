import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {ProductModel} from "../../model/product.model";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent {

  product = new ProductModel();


  constructor(private productService: ProductService, private router: Router) {
  }


  save() {
    this.productService.addProduct(this.product).subscribe(() => this.router.navigateByUrl('products'), error => console.log(error));
  }
}
