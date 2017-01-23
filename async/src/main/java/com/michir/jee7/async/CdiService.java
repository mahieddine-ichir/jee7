package com.michir.jee7.async;

import java.util.concurrent.ExecutionException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@ApplicationScoped
@Interceptors(LoggingInterceptor.class)
public class CdiService {

	@Inject
	private EjbService ejbService;

	@GET
	@Path("ntmcs")
	public void noTransactionalMethodCallingSync() {
		ejbService.syncMethod();
		System.out.println("[CDI/API Service] DO job");
	}

	@GET
	@Path("ntmca")
	public void noTransactionalMethodCallingAsyncWithoutReturn() {
		ejbService.asyncMethodWithoutReturn();
		System.out.println("[CDI/API Service] DO job");
	}

	@GET
	@Path("ntmcawraw")
	public void noTransactionalMethodCallingAsyncWithReturn() {
		try {
			ejbService.asyncMethodWithReturn().get(); // force wait
			System.out.println("[CDI/API Service] DO job");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("ntmcawr")
	public void noTransactionalMethodCallingAsyncWithReturnNoWait() {
		ejbService.asyncMethodWithReturn();
		System.out.println("[CDI/API Service] DO job");
	}

	@GET
	@Path("tmcs")
	@Transactional
	public void transactionalMethodCallingSync() {
		ejbService.syncMethod();
		System.out.println("[CDI/API Service] DO job");
	}

	@GET
	@Path("tmca")
	@Transactional
	public void transactionalMethodCallingAsyncWithoutReturn() {
		ejbService.asyncMethodWithoutReturn();
		System.out.println("[CDI/API Service] DO job");
	}

	@GET
	@Path("tmcawraw")
	@Transactional
	public void transactionalMethodCallingAsyncWithReturnAndWait() {
		try {
			ejbService.asyncMethodWithReturn().get(); // force wait
			System.out.println("[CDI/API Service] DO job");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("tmcawr")
	@Transactional
	public void transactionalMethodCallingAsyncWithReturn() {
		ejbService.asyncMethodWithReturn();
		System.out.println("[CDI/API Service] DO job");
	}
}
