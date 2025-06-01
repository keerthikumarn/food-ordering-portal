import { Injectable } from "@angular/core";
import { FOOD_MENU_API_URL } from "../../constants/url";
import { HttpClient } from "@angular/common/http";
import { Observable, catchError, throwError } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class FoodItemService{
    private apiUrl=FOOD_MENU_API_URL + '/foodmenu/fetchRestaurantAndFoodItemsById/';
    constructor(private http: HttpClient){

    }
    getFoodItemsByRestaurant(id:number): Observable<any>{
        return this.http.get<any>(`${this.apiUrl}${id}`)
        .pipe(
            catchError(this.handleError)
        );
    }
    private handleError(error: any){
        console.log('An error occured:', error);
        return throwError(error.message ||error)
    }
}
