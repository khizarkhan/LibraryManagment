import { Injectable } from '@angular/core';
import { Liberary } from './liberary';
import { HttpClient } from '@angular/common/http';
import { Books } from './books';


@Injectable({
  providedIn: 'root'
})
export class LiberayServiceService {
 
  constructor(private httpClient : HttpClient) { }
  libeary: Liberary[] = [];
  books: Books[] = [];
  getLibrary(): Liberary[]{
   
  
    this.httpClient.get("http://localhost:8080/getLibrary").subscribe(data => {
      
      this.libeary.push(data);
      
    });
    console.log(this.libeary[0]);
    
    debugger;
    console.log(this.libeary);
    return this.libeary;
   
  }

  getBooks(id : number) : Books[]{
    this.httpClient.get("http://localhost:8080/getBook/"+id).subscribe(data => {
      
      this.books.push(data);
      
    });
     debugger;
     console.log(this.books);
     return this.books;
  }
}
