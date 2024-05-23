package com.assignment.bcd.message;

import com.assignment.bcd.impl.IOTDataBean;
import com.assignment.bcd.remote.IOTData;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.TextMessage;
import org.json.JSONObject;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myTopic")
        }
)
public class IOTDataSubscriber implements MessageListener {
    private final IOTData iotData = new IOTDataBean();
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String jsonStr = textMessage.getText();

                JSONObject jsonObject = new JSONObject(jsonStr);

                iotData.addIOTData(jsonObject);

//                System.out.println("Received JSON Object:");
//                System.out.println(jsonObject.toString(4));
            } else {
                System.out.println("Received message of unexpected type: " + message.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
