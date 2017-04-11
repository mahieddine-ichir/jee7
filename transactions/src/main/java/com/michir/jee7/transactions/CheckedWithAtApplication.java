package com.michir.jee7.transactions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class CheckedWithAtApplication extends Exception {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1L;

}
