package via.sep4.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * The interface Room repository. It contains methods for performing CRUD operations,
 *  * sorting and paginating data
 */
@Component
public interface RoomRepository extends JpaRepository<Room, Long> {
    /**
     * Find room by roomid.
     *
     * @param roomid the roomid
     * @return the room
     */
    Room findByRoomidIs(Long roomid);
}
