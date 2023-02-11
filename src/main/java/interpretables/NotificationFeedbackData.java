package interpretables;

import java.time.LocalDate;

public class NotificationFeedbackData extends DataPack {

	public NotificationFeedbackData(String personIdentifier, LocalDate date) {
		super(personIdentifier, date);
		dataFormat = DataFormatEnum.NOTIFICATION_FEEDBACK;
	}
}
