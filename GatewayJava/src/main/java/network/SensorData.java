package network;

public class SensorData extends NetworkPackage{

    private Object object;
    /**
     * Constructor
     *
     * @param type
     */
    public SensorData(NetworkType type, Object object) {
        super(type);
        this.object = object;
    }

    /**
     * Returns a shift
     * @return shift
     */
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * String value of the all information in the shift and the enum network type
     * @return A string with ingormation
     */
    @Override
    public String toString() {
        return getType() + ": " + object;
    }
}
