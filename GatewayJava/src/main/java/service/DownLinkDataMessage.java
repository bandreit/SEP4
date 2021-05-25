package service;

public class DownLinkDataMessage {
    private final String cmd = "tx";
    private final String EUI = "0004A30B002523BC";
    private final int port = 1;
    private boolean confirmed;
    private String data;

    public DownLinkDataMessage(boolean confirmed, String data) {
        this.confirmed = confirmed;
        this.data = data;
    }

    public String getCmd() {
        return cmd;
    }

    public String getEUI() {
        return EUI;
    }

    public int getPort() {
        return port;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
