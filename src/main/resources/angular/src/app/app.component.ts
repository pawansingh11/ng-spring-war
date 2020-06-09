import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular';

  constructor(
    private http: HttpClient
  ){}

  hello = () => {
    this.http.get('http://localhost:8080/hello-bean').subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    )
  }
}
