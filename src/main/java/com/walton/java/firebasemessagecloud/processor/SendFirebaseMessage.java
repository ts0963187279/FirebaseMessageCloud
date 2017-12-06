package com.walton.java.firebasemessagecloud.processor;

import com.walton.java.firebasemessagecloud.model.FirebaseMessage;
import com.walton.java.socket.processor.GetSSLSocket;
import poisondog.core.Mission;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class SendFirebaseMessage implements Mission<FirebaseMessage> {
    private String authorizationKey;
    private String registrationToken;
    public SendFirebaseMessage(String authorizationKey, String registrationToken){
        this.authorizationKey = authorizationKey;
        this.registrationToken = registrationToken;
    }
    public Void execute(FirebaseMessage firebaseMessage){
        URL url = null;
        try {
            url = new URL("https://fcm.googleapis.com/fcm/send");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String body = "{\r\n" +
                "  \"notification\": {\r\n" +
                "    \"title\": \""+firebaseMessage.getTitle()+"\",\r\n" +
                "    \"body\": \""+firebaseMessage.getBody()+"\"\r\n" +
                "  },\r\n" +
                "  \"to\" : \""+registrationToken+"\"\r\n" +
                "}\r\n";
        GetSSLSocket getHttpsSocket = new GetSSLSocket(443);
        Socket socket = getHttpsSocket.execute(url.getHost());
        try {
            DataOutputStream bw = new DataOutputStream(socket.getOutputStream());
            bw.writeBytes("POST " +url.getFile()+ " HTTP/1.1\r\n");
            bw.writeBytes("HOST: " +url.getHost()+ "\r\n");
            bw.writeBytes("Content-Type: application/json\r\n");
            bw.writeBytes("Content-Length: "+body.length()+"\r\n");
            bw.writeBytes("Authorization:key="+authorizationKey+"\r\n");
            bw.writeBytes("\r\n");
            bw.writeBytes(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
