package com.michir.jee7.async;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@LocalBean
@Interceptors(LoggingInterceptor.class)
public class EjbService {

    public void syncMethod() {
    	doJob();
    }
    
    @Asynchronous
    public Future<Boolean> asyncMethodWithReturn() {
    	doJob();
    	return new AsyncResult<Boolean>(Math.random() < 0.5 ? Boolean.TRUE : Boolean.FALSE);
    }
    
    @Asynchronous
    public void asyncMethodWithoutReturn() {
    	doJob();
    }

	private void doJob() {
		try {
			Thread.sleep(10000);
			System.out.println(">>> DONE");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
