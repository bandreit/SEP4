package via.sep4.network;

public class NetworkPackage {
    private NetworkType type;

    /**
     * Constructor
     * @param type
     */
    public NetworkPackage(NetworkType type)
    {
        this.type = type;
    }

    /**
     * Returns a type
     * @return a enum type
     */
    public NetworkType getType()
    {
        return type;
    }
}
