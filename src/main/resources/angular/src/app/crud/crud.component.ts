import { Component, OnInit } from '@angular/core';
import { TodoService } from '../services/todo.service';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.scss']
})
export class CrudComponent implements OnInit {
  todoList;
  editId;
  addList = false;
  cancleAddBtn = false;
  addSuccess = false;
  editSuccess = false;
  deleteSuccess = false;
  constructor(
    private todo: TodoService
  ) { }

  deleteList = (id) => {
    console.log(id);
    this.todo.deleteTodo(id).subscribe(
      data => {
        console.log(data);
        // this.popTodoData(id);
        this.refreshData();
        this.deleteSuccess = true;
      },
      error => {
        console.log(error);
      }
    );
  }

  // popTodoData = (id) => {
  //   this.todoList.forEach(i => {
  //     if (i.id == id) {
  //       this.todoList.splice(this.todoList.id, 1);
  //     }
  //   });
  // }

  updateList = (id) => {
    this.editId = id;
  }

  addData = (username, description, done) => {
    // console.log(username, description, isDone);
    const postData = {
      username,
      description,
      done,
      targetDate : new Date()
    };
    this.todo.addTodo(postData).subscribe(
      data => {
        console.log(data);
        // this.todoList.push(postData);
        this.refreshData();
        this.addSuccess = true;
        this.addList = false;
      },
      error => {
        console.log(error);
      }
    );
  }

  updateData = (username, description, done, id) => {
    // console.log(username, description, isDone);
    const postData = {
      username,
      description,
      done,
      targetDate : new Date(),
      id
    };
    // console.log(postData);

    this.todo.updateTodo(postData).subscribe(
      data => {
        console.log(data);
        this.refreshData();
        this.editId = null;
        this.editSuccess = true;
      },
      error => {
        console.log(error);
      }
    );
  }

  refreshData = () => {
    this.todo.getTodo('pawan').subscribe(
      data => {
        console.log(data);
        this.todoList = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
    this.refreshData();
  }

}
