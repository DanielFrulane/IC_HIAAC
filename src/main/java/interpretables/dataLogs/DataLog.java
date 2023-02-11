package interpretables.dataLogs;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import interpretables.DataFormatEnum;
import interpretables.DataPack;
import interpretables.GPSData;
import interpretables.GenderEnum;
import interpretables.ItemPurchaseData;
import interpretables.NotificationFeedbackData;
import interpretables.StructuredTabularData;
import interpretables.UnstructuredTextData;

public abstract class DataLog {
	private ArrayList<DataPack> log;
	
	public DataLog() {
		log = new ArrayList<DataPack>();
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
