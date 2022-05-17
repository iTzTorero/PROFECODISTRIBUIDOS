/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

/**
 *
 * @author Juan Pablo
 */
public class Producer {

    private static final String EXCHANGE_NAME = "logs";

    public void enviarAvisoMulta(JSONObject jsonmensaje) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            JSONObject json = new JSONObject();
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            json.put("destinatario", jsonmensaje.getString("email"));
            json.put("asunto", "AVISO PROFECO");
            json.put("mensaje", "Usted ha sido acreedor a una multa \n"
                    + "Detalles del reporte:\n"
                    + "Descripcion: " + jsonmensaje.getString("descripcion") + "\n"
                    + "Importe: " + jsonmensaje.getDouble("importe") + "\n"
                    + "Quedamos pendientes a cubrir el importe de la multa. \n"
                    + "Procuraduría Federal del Consumidor\n");
            String message = json.toString();

            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
