package org.mlk007.kata.berlinclock;

import org.mlk007.kata.berlinclock.enums.LampColourEnum;

public class Lamp {

	private LampColourEnum lampColour;

	private boolean lampState = false;

	public Lamp(LampColourEnum lampColour) {
		this.lampColour = lampColour;
	}

	public String getStringRepresentation() {
		if (!lampState) {
			return "O";
		} 
		return lampColour.name().substring(0, 1);
	}

	public LampColourEnum getLampColour() {
		return lampColour;
	}

	public void setLampState(boolean lampState) {
		this.lampState = lampState;
	}

}
