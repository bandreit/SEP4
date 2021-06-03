package service;

/**
 * The type Up link data message.
 */
public class UpLinkDataMessage {
    private String cmd;
    private String EUI;
    private long ts;
    private boolean ack;
    private int fcnt;
    private int port;
    private String encdata;
    private String data;
    private int freq;
    private String dr;
    private int rssi;
    private double snr;

    /**
     * Instantiates a new Up link data message.
     *
     * @param cmd     the cmd
     * @param EUI     the eui
     * @param ts      the ts
     * @param ack     the ack
     * @param fcnt    the fcnt
     * @param port    the port
     * @param encdata the encdata
     * @param data    the data
     * @param freq    the freq
     * @param dr      the dr
     * @param rssi    the rssi
     * @param snr     the snr
     */
    public UpLinkDataMessage(String cmd, String EUI, long ts, boolean ack, int fcnt, int port, String encdata, String data, int freq, String dr, int rssi, double snr) {
        this.cmd = cmd;
        this.EUI = EUI;
        this.ts = ts;
        this.ack = ack;
        this.fcnt = fcnt;
        this.port = port;
        this.encdata = encdata;
        this.data = data;
        this.freq = freq;
        this.dr = dr;
        this.rssi = rssi;
        this.snr = snr;
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
     * Sets cmd.
     *
     * @param cmd the cmd
     */
    public void setCmd(String cmd) {
        this.cmd = cmd;
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
     * Sets eui.
     *
     * @param EUI the eui
     */
    public void setEUI(String EUI) {
        this.EUI = EUI;
    }

    /**
     * Gets ts.
     *
     * @return the ts
     */
    public long getTs() {
        return ts;
    }

    /**
     * Sets ts.
     *
     * @param ts the ts
     */
    public void setTs(long ts) {
        this.ts = ts;
    }

    /**
     * Is ack boolean.
     *
     * @return the boolean
     */
    public boolean isAck() {
        return ack;
    }

    /**
     * Sets ack.
     *
     * @param ack the ack
     */
    public void setAck(boolean ack) {
        this.ack = ack;
    }

    /**
     * Gets fcnt.
     *
     * @return the fcnt
     */
    public int getFcnt() {
        return fcnt;
    }

    /**
     * Sets fcnt.
     *
     * @param fcnt the fcnt
     */
    public void setFcnt(int fcnt) {
        this.fcnt = fcnt;
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
     * Sets port.
     *
     * @param port the port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Gets encdata.
     *
     * @return the encdata
     */
    public String getEncdata() {
        return encdata;
    }

    /**
     * Sets encdata.
     *
     * @param encdata the encdata
     */
    public void setEncdata(String encdata) {
        this.encdata = encdata;
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

    /**
     * Gets freq.
     *
     * @return the freq
     */
    public int getFreq() {
        return freq;
    }

    /**
     * Sets freq.
     *
     * @param freq the freq
     */
    public void setFreq(int freq) {
        this.freq = freq;
    }

    /**
     * Gets dr.
     *
     * @return the dr
     */
    public String getDr() {
        return dr;
    }

    /**
     * Sets dr.
     *
     * @param dr the dr
     */
    public void setDr(String dr) {
        this.dr = dr;
    }

    /**
     * Gets rssi.
     *
     * @return the rssi
     */
    public int getRssi() {
        return rssi;
    }

    /**
     * Sets rssi.
     *
     * @param rssi the rssi
     */
    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    /**
     * Gets snr.
     *
     * @return the snr
     */
    public double getSnr() {
        return snr;
    }

    /**
     * Sets snr.
     *
     * @param snr the snr
     */
    public void setSnr(double snr) {
        this.snr = snr;
    }

    @Override
    public String toString() {
        return "Service.UpLinkDataMessage{" +
                "cmd='" + cmd + '\'' +
                ", EUI='" + EUI + '\'' +
                ", ts=" + ts +
                ", ack=" + ack +
                ", fcnt=" + fcnt +
                ", port=" + port +
                ", encdata='" + encdata + '\'' +
                ", data='" + data + '\'' +
                ", freq=" + freq +
                ", dr='" + dr + '\'' +
                ", rssi=" + rssi +
                ", snr=" + snr +
                '}';
    }
}
