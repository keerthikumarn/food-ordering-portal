import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResturantListingRoutingModule } from './resturant-listing-routing.module';
import { ResturantListingComponent } from './components/resturant-listing.component';


@NgModule({
  declarations: [
    ResturantListingComponent
  ],
  imports: [
    CommonModule,
    ResturantListingRoutingModule,
  ],
  exports:[ResturantListingComponent]
})
export class ResturantListingModule { }
