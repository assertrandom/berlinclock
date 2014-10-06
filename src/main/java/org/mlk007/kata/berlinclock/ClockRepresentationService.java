package org.mlk007.kata.berlinclock;

import java.util.StringTokenizer;

public class ClockRepresentationService {

	private LampCreationService lampCreationService;

	public ClockRepresentationService() {
		setLampCreationService(new LampCreationService());
	}


	public String getBerlinClockRepresentationForDate(String dateStr) {
		StringTokenizer dateTokenizer = new StringTokenizer(dateStr, ":");
		if (dateTokenizer.countTokens() != 3) 
			throw new IllegalArgumentException("Incorrect input format " + dateStr);
		
		int hours = Integer.parseInt(dateTokenizer.nextToken());
		int minutes = Integer.parseInt(dateTokenizer.nextToken());
		int seconds = Integer.parseInt(dateTokenizer.nextToken());
		
		return assembleBerlinClockFormat(hours, minutes, seconds);
		
	}


	private String assembleBerlinClockFormat(int hours, int minutes, int seconds) {
		String returnVal = getLampCreationService().getFirstRowForSeconds(seconds) + " " + getLampCreationService().getSecondRowForHours(hours) + 
				" " + getLampCreationService().getThirdRowForHours(hours) + " " + getLampCreationService().getFourthRowForMinutes(minutes) + 
				" " + getLampCreationService().getFifthRowForMinutes(minutes);
		return returnVal;
	}


	public LampCreationService getLampCreationService() {
		return lampCreationService;
	}


	public void setLampCreationService(LampCreationService lampCreationService) {
		this.lampCreationService = lampCreationService;
	}
	

}
