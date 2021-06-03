package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Charts.DataRooms;
import via.sep4.model.Charts.DataToSendRooms;
import via.sep4.model.Room.Room;
import via.sep4.model.Room.RoomRepository;

import java.util.ArrayList;
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
    public DataToSendRooms findAll() {
        DataRooms createData = new DataRooms();
        List<DataRooms> arrayListOfData = new ArrayList<>();
        List<Room> allRooms = roomRepository.findAll();
        for (Room room : allRooms) {
            createData.setRoomid(room.getRoomid());
            createData.setRoomname(room.getRoomname());
            createData.setListOfSensors(room.getSensors());
            arrayListOfData.add(createData);
        }
        DataToSendRooms send = new DataToSendRooms();
        send.setData(arrayListOfData);
        return send;
    }
}