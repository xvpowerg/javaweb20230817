package tw.com.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.bean.Msg;

@ServerEndpoint("/websocket")
public class WebSocketServer {
	private static Map <String,Session> sessionMap = new HashMap();
	@OnMessage
	public void onMessage(String message,Session session) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objMap = new ObjectMapper();
		Msg msg =  objMap.readValue(message, Msg.class);
		//System.out.println(msg);
		session.getBasicRemote().sendText("我收到訊息了:"+message);
		Session fromSession = session;
		Session toUserSession = null;
		
		if(sessionMap.containsKey(msg.getFromUser())) {
			fromSession = sessionMap.get(msg.getFromUser());
		}else {
			sessionMap.put(msg.getFromUser(), session);
		}
		
		if (sessionMap.containsKey(msg.getToUser())) {
			toUserSession = sessionMap.get(msg.getToUser());
			toUserSession.getBasicRemote().sendText(msg.getMsg());
		}else {
			fromSession.getBasicRemote().sendText("無法傳送");
		}
		
	}
	
}
