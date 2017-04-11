package com.michir.jee7.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Transactional
public class BackendResource {

	@Inject
	EJBService service; 
	
	public Object get() throws Throwable {
		return service.get();
	}

	
	@Produces
	public Logger logger(InjectionPoint ip) {
		return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
	}
}
