package org.mlk007.kata.berlinclock;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClockRepresentationServiceTest {

	Logger logger = LoggerFactory.getLogger(ClockRepresentationServiceTest.class);
	
	private ClockRepresentationService clockRepresentationService;
	
	@Before
	public void setUp() throws Exception {
		clockRepresentationService = new ClockRepresentationService();
	}

	@Test
	public void testSecondsIndicatorLamp() {
	}

}
