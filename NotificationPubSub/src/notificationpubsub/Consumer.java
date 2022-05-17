/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationpubsub;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import notificationpubsub.MailManager;

/**
 *
 * @author Juan Pablo
 */
public class Consumer {

    private static MailManager mail;
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        mail = new MailManager();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            JSONObject json = new JSONObject(message);
            System.out.println("correo enviado a: " + json.getString("destinatario"));
            mail.enviarCorrero(json.getString("destinatario"), json.getString("asunto"), json.getString("mensaje"));
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
