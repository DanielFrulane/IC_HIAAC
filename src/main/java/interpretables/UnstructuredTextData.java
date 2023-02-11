package interpretables;

import java.time.LocalDate;

public class UnstructuredTextData extends DataPack {

	public UnstructuredTextData(String personIdentifier, LocalDate date) {
		super(personIdentifier, date);
		dataFormat = DataFormatEnum.UNSTRUCTURED_TEXT;
	}
}
