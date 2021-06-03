package via.sep4.model.Room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import via.sep4.model.Charts.DataToSendRooms;
import via.sep4.service.RoomService;

/**
 * The type Room controller.
 */
@RequestMapping("/SEP4")
@RestController
public class RoomController {
    private final RoomService roomService;

    /**
     * Instantiates a new Room controller.
     *
     * @param roomService the room service
     */
    RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * All list.
     *
     * @return the list containing the rooms and everything they contain
     */
    @GetMapping("/rooms")
    DataToSendRooms all() {
        return roomService.findAll();
    }
}
