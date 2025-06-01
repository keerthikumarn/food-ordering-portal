import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
import { RESTAURANT_LISTING_API_URL } from "../../constants/url";

@Injectable({
    providedIn: 'root'
})

export class RestaurantService{

    private apiurl = RESTAURANT_LISTING_API_URL+'/restaurant/getAllRestaurants';
    constructor(private http: HttpClient){ }

    getAllRestaurants(): Observable<any> {
        return this.http.get<any>(this.apiurl)
        .pipe(
            catchError(this.handleError)
        );
    }
    private handleError(error:any){
        console.error('An error occured:', error);
        return throwError(error.message || error);
    }
}