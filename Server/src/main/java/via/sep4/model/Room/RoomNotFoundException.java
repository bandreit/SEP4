package via.sep4.model.Room;

public class RoomNotFoundException extends RuntimeException {
    RoomNotFoundException()
    {
        super("Could not access the parameter");
    }
}
