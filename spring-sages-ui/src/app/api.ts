import {environment} from "../environments/environment";

export class Api {

  users = `${environment.baseUrl}users`;

  products = `${environment.baseUrl}products`;
}
