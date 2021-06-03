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
        List<DataRooms> arrayListOfData = new ArrayList<>();
        List<Room> allRooms = roomRepository.findAll();
        for (int i = 0; i < allRooms.size(); i++) {
            DataRooms createData = new DataRooms();
            createData.setRoomid(allRooms.get(i).getRoomid());
            createData.setRoomname(allRooms.get(i).getRoomname());
            createData.setListOfSensors(allRooms.get(i).getSensors());
            arrayListOfData.add(createData);
        }
        DataToSendRooms send = new DataToSendRooms();
        send.setData(arrayListOfData);
        return send;
    }
}
