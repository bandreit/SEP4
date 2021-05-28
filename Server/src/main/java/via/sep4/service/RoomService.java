package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Room.Room;
import via.sep4.model.Room.RoomRepository;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {

        return roomRepository.findAll();
    }
}