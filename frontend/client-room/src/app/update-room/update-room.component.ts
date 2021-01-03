import { Component, OnInit } from '@angular/core';
import {Room} from '../room';
import {ActivatedRoute, Router} from '@angular/router';
import {RoomService} from '../room.service';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.css']
})
export class UpdateRoomComponent implements OnInit {

  id: number;
  room: Room;
  submitted = false;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomService: RoomService) { }

  ngOnInit(): void {
    this.room = new Room();
    this.id = this.route.snapshot.params.id;
    this.roomService.getRoom(this.id)
      .subscribe(data => {
        console.log(data);
        this.room = data;
    }, error => console.error(error));
  }

  updateRoom(): void {
    this.roomService.updateRoom(this.id, this.room)
      .subscribe( data => {
        console.log(data);
    }, error => console.error(error));
    this.room = new Room();
    this.gotoList();
  }

  onSubmit(): void {
    this.updateRoom();
  }

  gotoList(): void {
    this.router.navigate(['/rooms']);
  }

}
