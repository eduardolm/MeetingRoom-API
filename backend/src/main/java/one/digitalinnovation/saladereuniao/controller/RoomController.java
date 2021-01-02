package one.digitalinnovation.saladereuniao.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import one.digitalinnovation.saladereuniao.exception.ResourceNotFoundException;
import one.digitalinnovation.saladereuniao.model.Room;
import one.digitalinnovation.saladereuniao.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/rooms")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Room>> getAll() {
        List<Room> roomList = roomService.getAll();

        return ResponseEntity.ok().body(roomList);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> getById(@PathVariable() long id) throws ResourceNotFoundException {
        Room room = roomService.getById(id);

        return ResponseEntity.ok().body(room);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Room> create(@Valid @RequestBody Room room) {
        Room createdRoom = roomService.create(room);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/api/v1/rooms")
                .build()
                .toUri();

        return ResponseEntity.created(location).body(createdRoom);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Room> update(@PathVariable() long id, @Valid @RequestBody Room room) throws ResourceNotFoundException {
        Room updatedRoom = roomService.update(id, room);

        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Room> delete(@PathVariable() long id) throws ResourceNotFoundException {
        Room room = roomService.getById(id);
        roomService.delete(id);
        return ResponseEntity.ok().body(room);
    }

}
