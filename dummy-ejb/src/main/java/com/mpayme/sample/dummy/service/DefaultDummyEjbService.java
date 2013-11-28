/**
 * Copyright (C) 2013 MPayMe Limited
 * All rights reserved.
 */
package com.mpayme.sample.dummy.service;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Leonard Siu
 *
 */
@Stateless
@Remote(DummyEjbService.class)
public class DefaultDummyEjbService implements DummyEjbService {
	
	private static final Logger log = LoggerFactory.getLogger(DefaultDummyEjbService.class);

	@Override
	public Map<String, String> test(Map<String, String> request) {
		Map<String, String> result = new HashMap<String, String>();
		
		String pauseStr = request.get("PAUSE");
		long pause = 1000L;
		
		log.info("Enter DummyEJBService.test. Simulate long transaction. Pause for {} second", pause);		
		try {
			if (pauseStr != null) pause = Long.parseLong(pauseStr);
		} catch (NumberFormatException e) {
			// Nop
		}
		
		for (long i = 0; i < pause; i += 100) {
			log.info("{} milliseconds passed xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// NOP
			}
		}
		
		log.info("Exit DummyEJBService.test in {} milliseconds", pause);
		
		return result;
	}

}
