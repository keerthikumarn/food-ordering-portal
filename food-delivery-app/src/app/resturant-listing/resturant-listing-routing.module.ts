import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResturantListingComponent } from './components/resturant-listing.component';

const routes: Routes = [
  { path:'', component: ResturantListingComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ResturantListingRoutingModule { }
