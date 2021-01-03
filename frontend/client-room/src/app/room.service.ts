import { Injectable } from '@angular/core';
import {Room} from './room';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseUrl = 'http://localhost:8080/api/v1/rooms';

  constructor(private httpClient: HttpClient) { }

  getRoomList(): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}`);
  }

  deleteRoom(id: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  createRoom(room: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, room);

  }

  getRoom(id: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}/${id}`);
  }

  updateRoom(id: number, room: Room): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, room);

  }
}
