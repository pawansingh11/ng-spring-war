import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  // tslint:disable-next-line: no-inferrable-types
  url: string = environment.url;
  constructor(
    private http: HttpClient
  ) { }

  getTodo = (user) => {
    return this.http.get(this.url + `/users/${user}/todos`);
  }

  deleteTodo = (id) => {
    const user = 'pawan';
    return this.http.delete(this.url + `/users/${user}/todos/${id}`);
  }
  addTodo = (data) => {
    const user = 'pawan';
    return this.http.post(this.url + `/users/${user}/todos`, data);
  }

  updateTodo = (data) => {
    const user = 'pawan';
    console.log('data in update service', data);

    return this.http.put(this.url + `/users/${user}/todos/${data.id}`, data);
  }
}
