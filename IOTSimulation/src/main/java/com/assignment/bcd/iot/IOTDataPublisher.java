package com.assignment.bcd.iot;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class IOTDataPublisher {
    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();

            TopicConnectionFactory factory= (TopicConnectionFactory) context.lookup("myTopicConnectionFactory");


            TopicConnection connection = factory.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = (Topic) context.lookup("myTopic");
            TopicPublisher publisher = session.createPublisher(topic);

            IOTDevice iotDevice;

            while (true) {
                iotDevice = new IOTDevice();
                String data = iotDevice.captureData();

                TextMessage message = session.createTextMessage();
                message.setText(data);

                publisher.publish(message);

                Thread.sleep(2000);
            }

        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
