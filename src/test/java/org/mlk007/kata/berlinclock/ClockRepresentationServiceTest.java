package org.mlk007.kata.berlinclock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClockRepresentationServiceTest {

	Logger logger = LoggerFactory.getLogger(ClockRepresentationServiceTest.class);
	
	private ClockRepresentationService clockRepresentationService;
	

	LampCreationService lampCreationService;
	
	@Before
	public void setUp() throws Exception {
		clockRepresentationService = new ClockRepresentationService();
	}

	@Test
	public void testClockRepresentationStringFormat1() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "13:17:01";
		String dateBerlinClockFormat = clockRepresentationService.getBerlinClockRepresentationForDate(dateStr);
		assertEquals("O RROO RRRO YYROOOOOOOO YYOO", dateBerlinClockFormat);
	}
	
	@Test
	public void testClockRepresentationStringFormat2() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "23:59:59";
		String dateBerlinClockFormat = clockRepresentationService.getBerlinClockRepresentationForDate(dateStr);
		assertEquals("O RRRR RRRO YYRYYRYYRYY YYYY", dateBerlinClockFormat);
	}
	
	@Test
	public void testClockRepresentationStringFormat3() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "24:00:00";
		String dateBerlinClockFormat = clockRepresentationService.getBerlinClockRepresentationForDate(dateStr);
		assertEquals("Y RRRR RRRR OOOOOOOOOOO OOOO", dateBerlinClockFormat);
	}	
	
	@Test
	public void testCreationServiceCalls() {
		
		lampCreationService = Mockito.mock(LampCreationService.class);

		String dateStr = "13:17:01";
		clockRepresentationService.setLampCreationService(lampCreationService);
		clockRepresentationService.getBerlinClockRepresentationForDate(dateStr);

		verify(lampCreationService).getSecondRowForHours(13);
		verify(lampCreationService).getFirstRowForSeconds(01);
		verify(lampCreationService).getFifthRowForMinutes(17);
		verify(lampCreationService).getThirdRowForHours(13);
	}
	

}
