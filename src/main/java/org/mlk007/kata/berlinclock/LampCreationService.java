package org.mlk007.kata.berlinclock;

import org.mlk007.kata.berlinclock.enums.LampColourEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LampCreationService {
	
	Logger logger = LoggerFactory.getLogger(LampCreationService.class);
	
	private static final int HOUR_ROW_LENGTH = 4;
	private static final int MINUTE_FIRST_ROW_LENGTH = 11;
	private static final int MINUTE_SECOND_ROW_LENGTH = 4;

	public String getFirstRowForSeconds(int seconds) {
		Lamp lamp = new Lamp(LampColourEnum.YELLOW);
		if (seconds % 2 == 0) 
			lamp.setLampState(true);
		return lamp.getStringRepresentation();
	}

	public String getSecondRowForHours(int hour) {
		validateHourValue(hour);

		int switchedOnLamps = hour / 5;
		return  getHoursRowsString(switchedOnLamps, HOUR_ROW_LENGTH, LampColourEnum.RED);
	}

	
	public String getThirdRowForHours(int hour) {
		validateHourValue(hour);

		int switchedOnLamps = hour % 5;
		return  getHoursRowsString(switchedOnLamps, HOUR_ROW_LENGTH, LampColourEnum.RED);
	}	

	public String getFourthRowForMinutes(int minute) {
		validateMinuteValue(minute);
		int switchedOnLamps = minute / 5;
		return  getMinutesFirstRowString(switchedOnLamps, MINUTE_FIRST_ROW_LENGTH);
	}

	public String getFifthRowForMinutes(int minutes) {
		validateMinuteValue(minutes);

		int switchedOnLamps = minutes % 5;
		return  getHoursRowsString(switchedOnLamps, MINUTE_SECOND_ROW_LENGTH, LampColourEnum.YELLOW);
	}	
	
	private void validateHourValue(int hour) {
		if (hour < 0 || hour > 24) 
			throw new IllegalArgumentException("Value of hour should be between 0 and 24");
	}

	private void validateMinuteValue(int minute) {
		if (minute < 0 || minute > 60) 
			throw new IllegalArgumentException("Value of minute should be between 0 and 60");
	}

	private String getHoursRowsString(int switchedOnLamps, int lampCount, LampColourEnum lampColourEnum) {
		StringBuffer lampRowRepresentation = new StringBuffer();

		for (int count= 0; count < lampCount; count++) {
			Lamp lamp = new Lamp(lampColourEnum);
			if (switchedOnLamps > count)  
				lamp.setLampState(true);
			lampRowRepresentation.append(lamp.getStringRepresentation());
		}
		return lampRowRepresentation.toString();
	}


	private String getMinutesFirstRowString(int switchedOnLamps, int lampCount) {
		StringBuffer lampRowRepresentation = new StringBuffer();

		for (int count= 1; count <= lampCount; count++) {
			Lamp lamp;
			if (count %3 == 0) {
				 lamp = new Lamp(LampColourEnum.RED);
			} else {
				 lamp = new Lamp(LampColourEnum.YELLOW);
			}
			if (switchedOnLamps >= count)  
				lamp.setLampState(true);
			lampRowRepresentation.append(lamp.getStringRepresentation());
		}
		return lampRowRepresentation.toString();
	}	
	

}
