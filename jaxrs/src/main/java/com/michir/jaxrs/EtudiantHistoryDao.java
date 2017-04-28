package com.michir.jaxrs;

import java.util.Calendar;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(activationConfig = {
	    @ActivationConfigProperty(propertyName = "destinationLookup",
	            propertyValue = "java:jboss/jms/MyQueue"),
	    @ActivationConfigProperty(propertyName = "destinationType",
	            propertyValue = "javax.jms.Queue")
	})
//@Stateless
public class EtudiantHistoryDao implements MessageListener {

	@PersistenceContext(unitName="pu")
	private EntityManager entityManager;
	
	public Future<Boolean> onDelete(Etudiant e) {
		Logger.getLogger(this.getClass().getName()).warning("History of etudiant "+e.getId());
		EtudiantHistory eh = new EtudiantHistory();
		eh.setDeletionDate(Calendar.getInstance().getTime());
		eh.setEtudiantId(new Long(e.getId()));
		eh.setEtudiantName(e.getNom());
		entityManager.persist(eh);
		try {
			Thread.sleep(3000);
			Logger.getLogger(this.getClass().getName()).warning("History of etudiant "+e.getId()+"... terminated");
			return new AsyncResult<Boolean>(Boolean.TRUE);
		} catch (InterruptedException e1) {
			Logger.getLogger(this.getClass().getName()).warning(e1.getMessage());
			return new AsyncResult<Boolean>(Boolean.FALSE);
		}
	}
	
	@Asynchronous
	public void onDeleteNonBlocking(Etudiant e) {
		this.onDelete(e);
	}
	
	public void onUpdate(Etudiant e) {
		
	}

	public void onMessage(Message message) {
		try {
			Etudiant etudiant = new Etudiant();
			etudiant.setId(message.getIntProperty("etudiantId"));
			etudiant.setNom(message.getStringProperty("etudiantNom"));
			//etudiant = entityManager.find(Etudiant.class, );
			this.onDelete(etudiant);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
