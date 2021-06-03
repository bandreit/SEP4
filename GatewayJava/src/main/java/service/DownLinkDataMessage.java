package service;

/**
 * The type Down link data message.
 */
public class DownLinkDataMessage {
    private final String cmd = "tx";
    private final String EUI = "0004A30B002523BC";
    private final int port = 2;
    private boolean confirmed;
    private String data;

    /**
     * Instantiates a new Down link data message.
     *
     * @param confirmed the confirmed
     * @param data      the data
     */
    public DownLinkDataMessage(boolean confirmed, String data) {
        this.confirmed = confirmed;
        this.data = data;
    }

    /**
     * Gets cmd.
     *
     * @return the cmd
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * Gets eui.
     *
     * @return the eui
     */
    public String getEUI() {
        return EUI;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Is confirmed boolean.
     *
     * @return the boolean
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    /**
     * Sets confirmed.
     *
     * @param confirmed the confirmed
     */
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(String data) {
        this.data = data;
    }
}
