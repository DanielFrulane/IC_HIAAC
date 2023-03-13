package codelets;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryObject;
import main.java.interpretables.DataPack;
import main.java.interpretables.dataLogs.DataLog;

public class LogReaderCodelet extends Codelet {

	DataLog dataLog;
	private MemoryObject dataPackInputMO;

	public LogReaderCodelet(DataLog dataLog) {
		this.dataLog = dataLog;
		dataLog.resetPositionInList();
	}

	@Override
	public void accessMemoryObjects() {
		dataPackInputMO = (MemoryObject) this.getOutput("DATA_PACK_INPUT");
	}

	@Override
	public void calculateActivation() {
		;
	}

	@Override
	public void proc() {
		synchronized (dataPackInputMO) {
			System.out.println("proc reader");
			DataPack currentDataPack = dataLog.getCurrentDataPack();
			if (currentDataPack != null) {
				dataPackInputMO.setI(currentDataPack);
				System.out.print("Read: ");
				currentDataPack.printDataPack();
				dataLog.incrementPositionInList();
			}
		}
	}

}
