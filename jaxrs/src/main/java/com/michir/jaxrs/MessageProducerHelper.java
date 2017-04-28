package com.michir.jaxrs;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

@ApplicationScoped
public class MessageProducerHelper {

	@Resource(lookup = "java:/ConnectionFactory")
	private static ConnectionFactory connectionFactory;

	@Resource(lookup = "java:jboss/jms/MyQueue")
	private static Queue queue;
	
	void sendMessage(Etudiant e) throws JMSException {
		Connection conn = connectionFactory.createConnection();
		Session session = conn.createSession();
		MessageProducer producer = session.createProducer(queue);
		
		Message message = session.createMessage();
		message.setIntProperty("etudiantId", e.getId());
		message.setStringProperty("etudiantNom", e.getNom());
		producer.send(message);
		
		producer.close();
		session.close();
		conn.close();
	}
	
}
