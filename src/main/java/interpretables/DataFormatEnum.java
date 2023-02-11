package interpretables;

import java.util.concurrent.ThreadLocalRandom;

public enum DataFormatEnum {
	STRUCTURED_TABULAR, UNSTRUCTURED_TEXT, GPS, ITEM_PURCHASE, NOTIFICATION_FEEDBACK;

	public static DataFormatEnum RandomUnstructuredDataFormatEnum() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
		switch (randomNum) {
		case 0:
			return UNSTRUCTURED_TEXT;
		case 1:
			return GPS;
		case 2:
			return ITEM_PURCHASE;
		case 3:
			return NOTIFICATION_FEEDBACK;
		}
		return null;
	}
}
