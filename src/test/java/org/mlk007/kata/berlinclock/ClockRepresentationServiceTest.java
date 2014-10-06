package org.mlk007.kata.berlinclock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClockRepresentationServiceTest {

	Logger logger = LoggerFactory
			.getLogger(ClockRepresentationServiceTest.class);

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
		String dateBerlinClockFormat = clockRepresentationService
				.getBerlinClockRepresentationForDate(dateStr);
		assertEquals("O RROO RRRO YYROOOOOOOO YYOO", dateBerlinClockFormat);
	}

	@Test
	public void testClockRepresentationStringFormat2() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "23:59:59";
		String dateBerlinClockFormat = clockRepresentationService
				.getBerlinClockRepresentationForDate(dateStr);
		assertEquals("O RRRR RRRO YYRYYRYYRYY YYYY", dateBerlinClockFormat);
	}

	@Test
	public void testClockRepresentationStringFormat3() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "24:00:00";
		String dateBerlinClockFormat = clockRepresentationService
				.getBerlinClockRepresentationForDate(dateStr);
		assertEquals("Y RRRR RRRR OOOOOOOOOOO OOOO", dateBerlinClockFormat);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncorrectInputFormat() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "current date";
		String dateBerlinClockFormat = clockRepresentationService
				.getBerlinClockRepresentationForDate(dateStr);
		logger.debug(dateBerlinClockFormat);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncompleteInputFormat() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "12:12";
		String dateBerlinClockFormat = clockRepresentationService
				.getBerlinClockRepresentationForDate(dateStr);
		logger.debug(dateBerlinClockFormat);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testOutOfBoundsDateFormat() {
		lampCreationService = new LampCreationService();
		clockRepresentationService.setLampCreationService(lampCreationService);
		String dateStr = "32:12:12";
		String dateBerlinClockFormat = clockRepresentationService
				.getBerlinClockRepresentationForDate(dateStr);
		logger.debug(dateBerlinClockFormat);

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

	@Test
	public void testBerlinClockAssembleOrder() {

		lampCreationService = Mockito.mock(LampCreationService.class);

		clockRepresentationService.setLampCreationService(lampCreationService);

		when(lampCreationService.getFirstRowForSeconds(13)).thenReturn("1");
		when(lampCreationService.getSecondRowForHours(11)).thenReturn("2");
		when(lampCreationService.getThirdRowForHours(11)).thenReturn("3");
		when(lampCreationService.getFourthRowForMinutes(12)).thenReturn("4");
		when(lampCreationService.getFifthRowForMinutes(12)).thenReturn("5");

		String berlinFormat = clockRepresentationService
				.assembleBerlinClockFormat(11, 12, 13);
		assertEquals("1 2 3 4 5", berlinFormat);

	}

}
