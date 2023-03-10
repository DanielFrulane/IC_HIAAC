package main.java.interpretables.dataLogs;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import main.java.interpretables.*;

public abstract class DataLog {
	private ArrayList<DataPack> log;
	private int positionInList;
	
	public DataLog() {
		log = new ArrayList<DataPack>();
		positionInList = 0;
	}
	
	public void resetPositionInList() {
		positionInList = 0;
	}
	
	public void incrementPositionInList() {
		positionInList++;
	}
	
	public DataPack getCurrentDataPack() {
		if (0 <= positionInList && positionInList < log.size()) {
			return log.get(positionInList);
		}
		return null;
	}

	public void addData(DataPack data) {
		log.add(data);
	}
	
	//private LocalDate RandomDate() {}
	
	public void addStructuredTabularData() {
		String personIdentifier = "49178390471274"; // change to be more random
		String name = "Paula"; // change to be more random
		GenderEnum gender = GenderEnum.RandomGenderEnum();
		LocalDate birthday = LocalDate.now(); // change to be more random
		LocalDate date = LocalDate.now(); // change to be more random
		StructuredTabularData data = new StructuredTabularData(personIdentifier, date, name, gender, birthday);
		addData(data);
	}

	private void addRandomGPSData() {
		String personIdentifier = "49178390471274"; // change to be more random
		double latitude = ThreadLocalRandom.current().nextDouble(-90, 90);
		double longitude = ThreadLocalRandom.current().nextDouble(-90, 90);
		LocalDate date = LocalDate.now(); // change to be more random
		GPSData data = new GPSData(personIdentifier, date, latitude, longitude);
		addData(data);
	}
	
	private void addRandomUnstructuredTextData() {
		//LocalDate date = LocalDate.now(); // change to be more random
		//UnstructuredTextData data = new ;
		//addData(data);
	}
	
	private void addRandomItemPurchaseData() {
		//LocalDate date = LocalDate.now(); // change to be more random
		//ItemPurchaseData data = new ;
		//addData(data);
	}
	
	private void addRandomNotificationFeedbackData() {
		//LocalDate date = LocalDate.now(); // change to be more random
		//NotificationFeedbackData data = new ;
		//addData(data);
	}
	
	protected void addRandomUnstructuredData(DataFormatEnum dataType) {
		switch (dataType) {
		case GPS:
			addRandomGPSData();
			break;
		case UNSTRUCTURED_TEXT:
			addRandomUnstructuredTextData();
			break;
		case ITEM_PURCHASE:
			addRandomItemPurchaseData();
			break;
		case NOTIFICATION_FEEDBACK:
			addRandomNotificationFeedbackData();
			break;
		default:
			break;
		}
	}
	
	protected void addRandomuUnstructuredData() {
		DataFormatEnum dataType = DataFormatEnum.RandomUnstructuredDataFormatEnum();
		addRandomUnstructuredData(dataType);
	}

	public void printLog() { // chaange to call print method on datapack
	      for (int i = 0; i < log.size();i++) 
	      { 		      
	          log.get(i).printDataPack(); 		
	      }  
	}

}
