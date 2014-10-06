package org.mlk007.kata.berlinclock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mlk007.kata.berlinclock.enums.LampColourEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LampCreationServiceTest {

	private LampCreationService lampCreationService;
	
	Logger logger = LoggerFactory.getLogger(LampCreationServiceTest.class);
	
	@Before
	public void setUp() throws Exception {
		lampCreationService = new LampCreationService();
	}

	@Test
	public void testSecondsLampCreation() {
		Lamp lamp = lampCreationService.getSecondsLamp(0);
		assertEquals(lamp.getLampColour(), LampColourEnum.YELLOW);
		assertEquals("Y", lamp.getStringRepresentation());
		lamp = lampCreationService.getSecondsLamp(1);
		assertEquals("O", lamp.getStringRepresentation());
	}
	
	@Test
	public void testFirstLampsRow(){
		String firstLampsRowStr = lampCreationService.getFirstLampsRow(12);
		assertEquals("RROO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getFirstLampsRow(23);
		logger.debug(firstLampsRowStr);
		assertEquals("RRRR", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getFirstLampsRow(0);
		logger.debug(firstLampsRowStr);
		assertEquals("OOOO", firstLampsRowStr);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForHour() {
		String firstLampsRowStr = lampCreationService.getFirstLampsRow(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForHour() {
		String firstLampsRowStr = lampCreationService.getFirstLampsRow(25);
		logger.debug(firstLampsRowStr);
	}	
	
	@Test
	public void testSecondLampsRow(){
		String firstLampsRowStr = lampCreationService.getSecondLampsRow(12);
		assertEquals("RROO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getSecondLampsRow(23);
		logger.debug(firstLampsRowStr);
		assertEquals("RRRO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getSecondLampsRow(0);
		logger.debug(firstLampsRowStr);
		assertEquals("OOOO", firstLampsRowStr);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForSecondHour() {
		String firstLampsRowStr = lampCreationService.getSecondLampsRow(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForSecondHour() {
		String firstLampsRowStr = lampCreationService.getSecondLampsRow(25);
		logger.debug(firstLampsRowStr);
	}
	
	@Test
	public void testThirdLampsRow(){
		String firstLampsRowStr = lampCreationService.getThirdLampsRow(34);
		assertEquals("YYRYYROOOOO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getThirdLampsRow(23);
		logger.debug(firstLampsRowStr);
		assertEquals("YYRYOOOOOOO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getThirdLampsRow(0);
		logger.debug(firstLampsRowStr);
		assertEquals("OOOOOOOOOOO", firstLampsRowStr);
	}	

	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForMinutes() {
		String firstLampsRowStr = lampCreationService.getThirdLampsRow(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForMinutes() {
		String firstLampsRowStr = lampCreationService.getThirdLampsRow(65);
		logger.debug(firstLampsRowStr);
	}
	
	@Test
	public void testLastLampsRow(){
		String firstLampsRowStr = lampCreationService.getLastLampsRow(34);
		assertEquals("YYYY", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getLastLampsRow(23);
		logger.debug(firstLampsRowStr);
		assertEquals("YYYO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getLastLampsRow(0);
		logger.debug(firstLampsRowStr);
		assertEquals("OOOO", firstLampsRowStr);
	}	
	
	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForLastMinutes() {
		String firstLampsRowStr = lampCreationService.getLastLampsRow(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForLastRowMinutes() {
		String firstLampsRowStr = lampCreationService.getLastLampsRow(65);
		logger.debug(firstLampsRowStr);
	}
		
}
