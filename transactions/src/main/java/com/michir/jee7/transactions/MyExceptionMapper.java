package com.michir.jee7.transactions;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.ApplicationException;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

@Provider
public class MyExceptionMapper implements ExceptionMapper<Throwable> {

//	@Context
//	private Providers providers;
	
	@Inject
	EJBService service;
	
	@Override
	public Response toResponse(Throwable exception) {
		Map<String, String> map = new HashMap<>();
		map.put("message", exception.getMessage());
		map.put("class", exception.getClass().getName());
		if (service.list().contains(exception.getClass())) {
			//logger.error(exception.getMessage(), exception);
			return Response.status(Status.BAD_REQUEST).entity(map).build();
		} else {
//			return providers.getExceptionMapper(Exception.class).toResponse(exception); // loop
			throw new RuntimeException(exception);
		}
	}
}
