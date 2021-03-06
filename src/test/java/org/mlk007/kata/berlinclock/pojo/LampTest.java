package org.mlk007.kata.berlinclock.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mlk007.kata.berlinclock.enums.LampColourEnum;
import org.mlk007.kata.berlinclock.pojo.Lamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LampTest {
	
	Logger logger = LoggerFactory.getLogger(LampTest.class);
	
	private Lamp lamp;

	@Before
	public void setUp() throws Exception {
		lamp = new Lamp(LampColourEnum.RED);
	}

	@Test
	public void testVerifyLampColour() {
		assertEquals(lamp.getLampColour(), LampColourEnum.RED);
	}
	
	@Test
	public void testLampStringRepresentation() {
		assertEquals("O", lamp.getStringRepresentation());
		lamp.setLampState(true);
		logger.debug("Switching on the lamp  ");
		assertEquals("R", lamp.getStringRepresentation());
		
	}

}
