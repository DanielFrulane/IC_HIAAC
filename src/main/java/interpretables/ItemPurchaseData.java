package interpretables;

import java.time.LocalDate;

public class ItemPurchaseData extends DataPack {

	public ItemPurchaseData(String personIdentifier, LocalDate date) {
		super(personIdentifier, date);
		dataFormat = DataFormatEnum.ITEM_PURCHASE;
	}
}
