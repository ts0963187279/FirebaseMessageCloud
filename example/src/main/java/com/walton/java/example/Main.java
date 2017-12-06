package com.walton.java.example;

import com.walton.java.firebasemessagecloud.model.FirebaseMessage;
import com.walton.java.firebasemessagecloud.processor.SendFirebaseMessage;

import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("local");
        String authorizationKey = resourceBundle.getString("authorizationKey");
        String registrationToken = resourceBundle.getString("registrationToken");
        FirebaseMessage firebaseMessage = new FirebaseMessage();
        firebaseMessage.setTitle("example");
        firebaseMessage.setBody("test");
        SendFirebaseMessage sendFirebaseMessage = new SendFirebaseMessage(authorizationKey,registrationToken);
        sendFirebaseMessage.execute(firebaseMessage);
    }
}
