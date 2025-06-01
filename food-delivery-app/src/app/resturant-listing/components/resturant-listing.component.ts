import { ChangeDetectorRef, Component } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from '../service/resturant.service';
import { Restaurant } from '../../shared/model/Restaurant';

@Component({
  selector: 'app-resturant-listing',
  standalone: false,
  templateUrl: './resturant-listing.component.html',
  styleUrl: './resturant-listing.component.scss'
})
export class ResturantListingComponent {

  public restaurantList: Restaurant[];

  ngOnInit(): void {
    this.getAllRestaurants();
  }
  constructor(private cdRef: ChangeDetectorRef,private router: Router, private restaurantService: RestaurantService){

  }
  ngAfterViewInit(): void {
    // Simulate async change (e.g., after DOM view initialized)
    setTimeout(() => {
      this.cdRef.detectChanges(); // ✅ Safe and appropriate here
    });
  }
  getAllRestaurants(){
    this.restaurantService.getAllRestaurants().subscribe(
      data=> {
        this.restaurantList = data;
      }
    )
  }
  getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random()* (max - min+1)) + min;
  }

  getRandomImage(): string {
      const imageCount = 8;
      const randomIndex = this.getRandomNumber(1, imageCount);
      return `${randomIndex}.jpg`;
  }
  onButtonClick(id: any){
    this.router.navigate(['/food-catalog', id]);
  }
}
