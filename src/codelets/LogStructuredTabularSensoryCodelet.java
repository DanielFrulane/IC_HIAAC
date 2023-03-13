package codelets;

import br.unicamp.cst.core.entities.MemoryObject;
import main.java.interpretables.DataFormatEnum;
import main.java.interpretables.DataPack;

public class LogStructuredTabularSensoryCodelet extends SensoryCodelet {

	private MemoryObject structuredTabularDataMO;

	public LogStructuredTabularSensoryCodelet(MemoryObject dataPackInputMO) {
		super(dataPackInputMO);
	}

	@Override
	public void accessMemoryObjects() {
		dataPackInputMO = (MemoryObject) this.getInput("DATA_PACK_INPUT");
		structuredTabularDataMO = (MemoryObject) this.getOutput("STRUCTURED_TABULAR_DATA");
	}

	@Override
	public void calculateActivation() {
		;
	}

	@Override
	public void proc() {
		synchronized (structuredTabularDataMO) {
			System.out.println("proc structured");
			DataPack dataPack = (DataPack) dataPackInputMO.getI();
			if (dataPack != null && dataPack.getDataFormat() == DataFormatEnum.STRUCTURED_TABULAR) {
	        	structuredTabularDataMO.setI(dataPack);
				
			}
		}
	}
}
