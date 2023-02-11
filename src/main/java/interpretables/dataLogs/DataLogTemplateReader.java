package main.java.interpretables.dataLogs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Pattern;

import main.java.interpretables.DataPack;
import main.java.interpretables.GPSData;
import main.java.interpretables.GenderEnum;
import main.java.interpretables.StructuredTabularData;

public class DataLogTemplateReader extends DataLogFile {
	private final int numberOfLinesOfFile;
	private String[] partsOfLine;

	public DataLogTemplateReader(String filePath) throws IOException {
		super(filePath);
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		numberOfLinesOfFile = lines;
		
		interpretAllFile();
	}	

	@Override
	void interpretLine() {
		if (currentLineNumber == 1) {
			return;
		}
		else if (currentLineNumber == numberOfLinesOfFile) {
			return;
		}
		else {
			interpretNormalLine();
			return;
		}
	}
	
	private void interpretNormalLine() {
		partsOfLine = currentLine.split(Pattern.quote(","));
		if (isCurrentLineTabularData()) {
			interpretTabularData();
		}
		else if (isCurrentLineGPSData()) {
			interpretGPSData();
		}
		return;
	}
	
	private boolean isCurrentLineTabularData() {
		return (partsOfLine.length == 5);
	}
	
	private boolean isCurrentLineGPSData() {
		return (partsOfLine.length == 4);
	}
	
	private void interpretTabularData() {
		String personIdentifier = partsOfLine[0];
		LocalDate date = convertTextToLocalDate(partsOfLine[1]);
		String name = partsOfLine[2];
		GenderEnum gender = convertTextToGenderEnum(partsOfLine[3]);
		LocalDate birthday = convertTextToLocalDate(partsOfLine[4]);
		
		DataPack interpretedDataPack = new StructuredTabularData(personIdentifier, date, name, gender, birthday);
		addData(interpretedDataPack);
	}
	
	private void interpretGPSData() {
		String personIdentifier = partsOfLine[0];
		LocalDate date = convertTextToLocalDate(partsOfLine[1]);
		double latitude = convertTextToFloat(partsOfLine[2]);
		double longitude = convertTextToFloat(partsOfLine[3]);
		
		DataPack interpretedDataPack = new GPSData(personIdentifier, date, latitude, longitude);
		addData(interpretedDataPack);
	}
	
	private LocalDate convertTextToLocalDate(String text) { // ISO Local Date
		return LocalDate.parse(text);
	}
	
	private float convertTextToFloat(String text) {
		return Float.valueOf(text);
		
	}
	
	private GenderEnum convertTextToGenderEnum(String text) {
		switch (text) {
		case "M":
			return GenderEnum.MALE;
		case "F":
			return GenderEnum.FEMALE;
		case "O":
			return GenderEnum.OTHER;
		case "N":
			return GenderEnum.NONE;
		default:
			return null;
		}
	}
}
