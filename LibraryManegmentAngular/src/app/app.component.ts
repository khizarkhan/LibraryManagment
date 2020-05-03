import { Component, OnInit } from '@angular/core';
import { LiberayServiceService } from './liberay-service.service';
import { Liberary } from './liberary';
import { Books } from './books';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LiberaryManegment';
  liberay : Liberary;
  falg =true;
  
  books : Books ;
  l
  constructor(private lib :  LiberayServiceService){}
  

  showBooks(libeObj : number):Books[]{
  
   
  for(let x of this.lib.getBooks(libeObj)){
    
    this.books=x;
    
  }
  
  return null;
}

  showLibrary(){
    
    for(let obj of this.lib.getLibrary()){
      
      this.liberay=obj;
      this.falg=false;
      
    }
    
    return null;
    
  }
}
