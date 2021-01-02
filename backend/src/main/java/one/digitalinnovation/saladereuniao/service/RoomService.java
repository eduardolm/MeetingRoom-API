package one.digitalinnovation.saladereuniao.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.saladereuniao.exception.ResourceNotFoundException;
import one.digitalinnovation.saladereuniao.model.Room;
import one.digitalinnovation.saladereuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room getById(long id) throws ResourceNotFoundException {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
    }

    public Room create(Room room) {
        return roomRepository.save(room);
    }

    public Room update(long id, Room room) throws ResourceNotFoundException {
        verifyIfExists(id);
        room.setId(id);
        return roomRepository.save(room);
    }

    public void delete(long id) throws ResourceNotFoundException {
        verifyIfExists(id);
        roomRepository.deleteById(id);
    }

    private Room verifyIfExists(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + id));
    }
}
