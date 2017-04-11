package com.michir.jee7.transactions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;

@Stateless
@LocalBean
public class EJBService {

	List<Class<? extends Throwable>> set;

	@Inject
	Logger logger;
	
	@PostConstruct
	void init() {
		set = new ArrayList<Class<? extends Throwable>>() {

			/**
			 * UID
			 */
			private static final long serialVersionUID = 1L;

			List<Class<? extends Throwable>> init() {
				
//				add(RuntimeException.class);		// nope, rollback
				add(Unchcked.class);				// nope, rollback
				add(UncheckedWithAtApplication.class);	// client error (@ApplicationException), rollback
				add(Checked.class);			// client error
				add(CheckedWithAtApplication.class);		// client error
				
				return this;
			}

		}.init();
	}
	
	public List<Class<? extends Throwable>> list() {
		return set;
	}
	
	public Object get() throws Throwable {
		Integer index = (int) Math.round(Math.random()*(double)(set.size() - 1) - 0.5) + 1;
		logger.info("Fetching throwable "+index);
		
		if (Math.random() < 0.5) {
			throw new RuntimeException();
		} else {
			throw set.get(index).newInstance();
		}
		
	}

}
