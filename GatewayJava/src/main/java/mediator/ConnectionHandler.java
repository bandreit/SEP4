package mediator;

import java.io.IOException;

public interface ConnectionHandler {
    /**
     * Connect.
     *
     * @throws IOException the io exception
     */
    void connect() throws IOException;

    /**
     * Disconnect.
     *
     * @throws IOException the io exception
     */
    void disconnect() throws IOException;

    /**
     * Send to server.
     *
     * @param message the message
     * @throws IOException the io exception
     */
    void sendToServer(String message) throws IOException;

    /**
     * Read from server string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    String readFromServer() throws IOException;
}
