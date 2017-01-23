package com.michir.jee7.async;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		System.out.println(""+ctx.getTarget()+"."+ctx.getMethod());
		return ctx.proceed();
	}
	
}
