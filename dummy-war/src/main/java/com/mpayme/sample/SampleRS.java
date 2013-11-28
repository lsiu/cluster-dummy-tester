/**
 * Copyright (C) 2013 MPayMe Limited
 * All rights reserved.
 */
package com.mpayme.sample;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mpayme.sample.dummy.service.DummyEjbService;

//import com.mpayme.sample.dummy.service.DummyEjbService;

/**
 * @author Leonard Siu
 * 
 */
@Path("/test")
@Stateless
public class SampleRS {

	private static final Logger log = LoggerFactory.getLogger(SampleRS.class);
	
//	@EJB(lookup = "com.mpayme.sample.dummy.service.DummyEjbService")
//	private DummyEjbService svc;

	@GET
	@Produces("text/plain")
	public Response doGet(@DefaultValue("1000") @QueryParam("pause") long pause) {
		log.info("Enter SampleRS.doGet. Simulate long transaction. Pause for {} second", pause);

		for (long i = 0; i < pause; i += 100) {
			log.info("{} milliseconds passed xxxxxxxxxxxxxxxxxx", i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// NOP
			}
		}
		
		log.info("Exit doGet in {} milliseconds", pause);
		
//		Map<String, String> param = new HashMap<>();
//		param.put("PAUSE", String.valueOf(pause));
//		svc.test(param);
		
		return Response.ok(String.format("SampleRS.doGet paused for %s millsec and returned", pause)).build();
	}
}
