package service;

import com.google.gson.Gson;
import org.json.JSONObject;
import sensor.SensorConvertingService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * The type Websocket client.
 */
public class WebsocketClient implements WebSocket.Listener {
    private WebSocket server = null;
    private SensorConvertingService sensorConvertingService;
    private Gson gson;

    /**
     * Gets server.
     *
     * @return the server
     */
    public WebSocket getServer() {
        return server;
    }

    /**
     * Send down link.
     *
     * @param jsonTelegram the json telegram
     */
    // Send down-link message to device
    public void sendDownLink(String jsonTelegram) {
        server.sendText(jsonTelegram, true);
    }

    /**
     * Instantiates a new Websocket client.
     *
     * @param url the url
     */
// E.g. url: "wss://iotnet.teracom.dk/app?token=??????????????????????????????????????????????="
    // Substitute ????????????????? with the token you have been given
    public WebsocketClient(String url) {
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<WebSocket> ws = client.newWebSocketBuilder()
                .buildAsync(URI.create(url), this);

        server = ws.join();
        sensorConvertingService = new SensorConvertingService();
        gson = new Gson();
    }

    //onOpen()
    public void onOpen(WebSocket webSocket) {
        // This WebSocket will invoke onText, onBinary, onPing, onPong or onClose methods on the associated listener (i.e. receive methods) up to n more times
        webSocket.request(1);
        System.out.println("WebSocket Listener has been opened for requests.");
    }

    //onError()
    public void onError(WebSocket webSocket, Throwable error) {
        System.out.println("A " + error.getCause() + " exception was thrown.");
        System.out.println("Message: " + error.getLocalizedMessage());
        webSocket.abort();
    }

    //onClose()
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        System.out.println("WebSocket closed!");
        System.out.println("Status:" + statusCode + " Reason: " + reason);
        return new CompletableFuture().completedFuture("onClose() completed.").thenAccept(System.out::println);
    }

    //onPing()
    public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Ping: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return new CompletableFuture().completedFuture("Ping completed.").thenAccept(System.out::println);
    }

    //onPong()
    public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Pong: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return new CompletableFuture().completedFuture("Pong completed.").thenAccept(System.out::println);
    }

    //onText()
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        String indented = (new JSONObject(data.toString())).toString(4);
        System.out.println(indented);
        UpLinkDataMessage upLinkDataMessage = gson.fromJson(data.toString(), UpLinkDataMessage.class);
        if (upLinkDataMessage.getCmd().equals("rx"))
            sensorConvertingService.convertAndSend(upLinkDataMessage);
        webSocket.request(1);
        return new CompletableFuture().completedFuture("onText() completed.").thenAccept(System.out::println);
    }

}