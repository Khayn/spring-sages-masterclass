import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {Api} from "./api";
import {UsersListComponent} from './component/users-list/users-list.component';
import {UserService} from "./service/user.service";
import {UserFormComponent} from './component/user-form/user-form.component';
import {FormsModule} from "@angular/forms";
import {ProductFormComponent} from './component/product-form/product-form.component';
import {ProductsListComponent} from './component/products-list/products-list.component';
import {ProductService} from "./service/product.service";

@NgModule({
  declarations: [
    AppComponent,
    UsersListComponent,
    UserFormComponent,
    ProductFormComponent,
    ProductsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    Api,
    UserService,
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
