package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Room.Room;
import via.sep4.model.Room.RoomRepository;

import java.util.List;

/**
 * The type Room service.
 */
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    /**
     * Instantiates a new Room service.
     *
     * @param roomRepository the room repository
     */
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    /**
     * Gets all rooms from the repository.
     *
     * @return the list
     */
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}