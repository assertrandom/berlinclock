package org.mlk007.kata.berlinclock;

import java.util.Scanner;

public class RunBerlinClockConverter {

	public static void main(String[] args) {
		System.out
				.println("Please enter the time in hh:mm:ss format (Sample 19:30:45 ) ");
		Scanner scan = new Scanner(System.in);
		String inputLine = scan.nextLine();
		ClockRepresentationService clockRep = new ClockRepresentationService();
		String berlinClockFormat = clockRep
				.getBerlinClockRepresentationForDate(inputLine);
		System.out.println("Berlin Clock Format is ");
		System.out.println(berlinClockFormat);
		scan.close();
	}

}
