package main.java.interpretables;

import java.time.LocalDate;
import java.time.Period;

public class StructuredTabularData extends DataPack {
	private String name;
	private GenderEnum gender;
	private LocalDate birthday;

	public StructuredTabularData(String personIdentifier, LocalDate date, String name, GenderEnum gender, LocalDate birthday) {
		super(personIdentifier, date);
		dataFormat = DataFormatEnum.STRUCTURED_TABULAR;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public int getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public String getName() {
		return name;
	}
}
