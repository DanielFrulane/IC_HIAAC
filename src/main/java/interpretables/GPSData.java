package main.java.interpretables;

import java.time.LocalDate;

public class GPSData extends DataPack {
	private double latitude;
	private double longitude;
	
	public GPSData (String personIdentifier, LocalDate date, double latitude, double longitude) {
		super(personIdentifier, date);
		dataFormat = DataFormatEnum.GPS;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public void printDataPack() {
		System.out.print(personIdentifier);
		System.out.print(";");
		System.out.print(date);
		System.out.print(";");
		System.out.print(this.latitude);
		System.out.print(";");
		System.out.println(this.longitude);
	}
}
