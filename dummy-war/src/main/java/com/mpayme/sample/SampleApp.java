/**
 * Copyright (C) 2013 MPayMe Limited
 * All rights reserved.
 */
package com.mpayme.sample;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Leonard Siu
 * 
 */
@ApplicationPath("/")
public class SampleApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(SampleRS.class);
		return classes;
	}

}
