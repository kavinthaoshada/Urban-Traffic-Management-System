package com.assignment.bcd.iot;

import jakarta.jms.*;
import org.json.JSONObject;

import javax.naming.InitialContext;
import javax.naming.NamingException;
public class IOTDataReceiver {
    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();
            TopicConnectionFactory factory= (TopicConnectionFactory) context.lookup("myTopicConnectionFactory");

            TopicConnection connection = factory.createTopicConnection();
            connection.start();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = (Topic) context.lookup("myTopic");
            TopicSubscriber subscriber = session.createSubscriber(topic);

            subscriber.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        if (message instanceof TextMessage) {
                            TextMessage textMessage = (TextMessage) message;
                            String jsonStr = textMessage.getText();

                            JSONObject jsonObject = new JSONObject(jsonStr);

                            System.out.println("Received JSON Object:");
                            System.out.println(jsonObject.toString(4));
                        } else {
                            System.out.println("Received message of unexpected type: " + message.getClass().getName());
                        }
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }


                }
            });

            while(true){

            }

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
