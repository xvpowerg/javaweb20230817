package tw.com.web;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketServer {
	@OnMessage
	public void onMessage(String message,Session session) throws IOException, InterruptedException {
		session.getBasicRemote().sendText("����T���F!"+message);
		for (int i = 1; i<= 10; i++) {
			Thread.sleep(500);
			session.getBasicRemote().sendText("Sever Send msg:"+i+"�T��");
		}
		session.getBasicRemote().sendText("����!");
	}
}
