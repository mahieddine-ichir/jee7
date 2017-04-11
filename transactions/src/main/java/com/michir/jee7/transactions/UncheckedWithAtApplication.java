package com.michir.jee7.transactions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class UncheckedWithAtApplication extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6274915120671630658L;

}
