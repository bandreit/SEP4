package via.sep4.network;

/**
 * The type Network package.
 */
public class NetworkPackage {
    private final NetworkType type;
    private Object object;

    /**
     * Instantiates a new Network package.
     *
     * @param type   the type
     * @param object the object
     */
    public NetworkPackage(NetworkType type, Object object) {
        this.type = type;
        this.object = object;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public NetworkType getType() {
        return type;
    }

    /**
     * Gets object.
     *
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Sets object.
     *
     * @param object the object
     */
    public void setObject(Object object) {
        this.object = object;
    }
}
