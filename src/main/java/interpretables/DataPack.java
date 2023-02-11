package interpretables;

import java.time.LocalDate;

public abstract class DataPack {
	
	DataFormatEnum dataFormat;
	String personIdentifier; // CPF
	LocalDate date;

	public DataPack(String personIdentifier, LocalDate date) {
		this.personIdentifier = personIdentifier;
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getPersonIdentifier() {
		return personIdentifier;
	}

	public void printDataPack() { // TODO: override on subclasses
		System.out.print(personIdentifier);
		System.out.print(";");
		System.out.println(date);
	}
}