import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { ORDER_API_URL } from "../../constants/url";

@Injectable({
    providedIn: 'root'
})

export class OrderService {
    private apiUrl = ORDER_API_URL+'/order/save';

    constructor(private http: HttpClient){

    }
    httpOptions = {
        header: new HttpHeaders({
            'Content-Type' : "text/plain",
            'Access-Control-Allow-Origin' : 'http://localhost:44317/' //Replace with your Angular app url
        })
    };
    save(data: any): Observable<any> {
        return this.http.post<any>(this.apiUrl, data);
    }
    private handleError(error: any){
        console.error('An error occured', error);
        return throwError(error.message || error);
    }
}