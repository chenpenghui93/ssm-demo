package com.example.ssmdemo.helloworld.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author cph
 * @date 2019/5/28
 */
@ServerEndpoint("/websocket")
public class WebSocketTest {

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException {
        System.out.println("received: " + message);
        session.getBasicRemote().sendText("the first message from sever.");

        int i = 0;
        while (i < 10) {
            Thread.sleep(3000);
            session.getBasicRemote().sendText("intermediate server message, seq: " + i);
            i++;
        }

        session.getBasicRemote().sendText("the last message from sever.");

    }

    @OnOpen
    public void onOpen(){
        System.out.println("client connect.");
    }

    @OnClose
    public void onClose(){
        System.out.println("connection closed.");
    }
}
