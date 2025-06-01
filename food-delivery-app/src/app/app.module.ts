import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './header/header.module';
import { ResturantListingModule } from './resturant-listing/resturant-listing.module';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { FoodCatalogModule } from './food-catalog/food-catalog.module';
import { OrderSummaryModule } from './order-summary/order-summary.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule,
    ResturantListingModule,
    FoodCatalogModule,
    OrderSummaryModule
  ],
  providers: [
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
