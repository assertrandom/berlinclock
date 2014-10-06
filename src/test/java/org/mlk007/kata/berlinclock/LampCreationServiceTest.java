package org.mlk007.kata.berlinclock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
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
		String secondsRowStr = lampCreationService.getFirstRowForSeconds(0);
		assertEquals("Y", secondsRowStr);
		secondsRowStr = lampCreationService.getFirstRowForSeconds(1);
		assertEquals("O", secondsRowStr);
	}
	
	@Test
	public void testFirstLampsRow(){
		String firstLampsRowStr = lampCreationService.getSecondRowForHours(12);
		assertEquals("RROO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getSecondRowForHours(23);
		logger.debug(firstLampsRowStr);
		assertEquals("RRRR", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getSecondRowForHours(0);
		logger.debug(firstLampsRowStr);
		assertEquals("OOOO", firstLampsRowStr);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForHour() {
		String firstLampsRowStr = lampCreationService.getSecondRowForHours(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForHour() {
		String firstLampsRowStr = lampCreationService.getSecondRowForHours(25);
		logger.debug(firstLampsRowStr);
	}	
	
	@Test
	public void testSecondLampsRow(){
		String firstLampsRowStr = lampCreationService.getThirdRowForHours(12);
		assertEquals("RROO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getThirdRowForHours(23);
		logger.debug(firstLampsRowStr);
		assertEquals("RRRO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getThirdRowForHours(0);
		assertEquals("OOOO", firstLampsRowStr);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForSecondHour() {
		String firstLampsRowStr = lampCreationService.getThirdRowForHours(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForSecondHour() {
		String firstLampsRowStr = lampCreationService.getThirdRowForHours(25);
		logger.debug(firstLampsRowStr);
	}
	
	@Test
	public void testThirdLampsRow(){
		String firstLampsRowStr = lampCreationService.getFourthRowForMinutes(34);
		assertEquals("YYRYYROOOOO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getFourthRowForMinutes(23);
		logger.debug(firstLampsRowStr);
		assertEquals("YYRYOOOOOOO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getFourthRowForMinutes(0);
		logger.debug(firstLampsRowStr);
		assertEquals("OOOOOOOOOOO", firstLampsRowStr);
	}	

	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForMinutes() {
		String firstLampsRowStr = lampCreationService.getFourthRowForMinutes(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForMinutes() {
		String firstLampsRowStr = lampCreationService.getFourthRowForMinutes(65);
		logger.debug(firstLampsRowStr);
	}
	
	@Test
	public void testLastLampsRow(){
		String firstLampsRowStr = lampCreationService.getFifthRowForMinutes(34);
		assertEquals("YYYY", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getFifthRowForMinutes(23);
		logger.debug(firstLampsRowStr);
		assertEquals("YYYO", firstLampsRowStr);
		firstLampsRowStr = lampCreationService.getFifthRowForMinutes(0);
		logger.debug(firstLampsRowStr);
		assertEquals("OOOO", firstLampsRowStr);
	}	
	
	@Test (expected=IllegalArgumentException.class)
	public void testNegativeNumberForLastMinutes() {
		String firstLampsRowStr = lampCreationService.getFifthRowForMinutes(-1);
		logger.debug(firstLampsRowStr);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testOutOfLimitNumberForLastRowMinutes() {
		String firstLampsRowStr = lampCreationService.getFifthRowForMinutes(65);
		logger.debug(firstLampsRowStr);
	}
		
}
