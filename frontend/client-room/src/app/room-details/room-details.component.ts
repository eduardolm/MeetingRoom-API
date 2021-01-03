import {Component, OnInit} from '@angular/core';
import {Room} from '../room';
import {RoomService} from '../room.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css']
})
export class RoomDetailsComponent implements OnInit {

  id: number;
  room: Room;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private roomServce: RoomService) { }

  ngOnInit(): void {
    this.room = new Room();
    this.id = this.route.snapshot.params.id;
    this.roomServce.getRoom(this.id)
      .subscribe(data => {
        console.log(data);
        this.room = data;
    }, error => console.error(error));
  }

  list(): void {
    this.router.navigate(['rooms']);
  }

}
