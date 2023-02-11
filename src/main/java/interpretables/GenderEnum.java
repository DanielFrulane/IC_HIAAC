package main.java.interpretables;

import java.util.concurrent.ThreadLocalRandom;

public enum GenderEnum {
	MALE, FEMALE, OTHER, NONE;

	public static GenderEnum RandomGenderEnum() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
		switch (randomNum) {
		case 0:
			return MALE;
		case 1:
			return FEMALE;
		case 2:
			return OTHER;
		case 3:
			return NONE;
		}
		return null;
	}
}
