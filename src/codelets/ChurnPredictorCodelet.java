package codelets;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryObject;

public class ChurnPredictorCodelet extends Codelet {
	
	private MemoryObject structuredTabularDataMO;
	private MemoryObject gpsDataMO;
	private MemoryObject outputAnalysisMO;
	
	public ChurnPredictorCodelet() {
		;
	}

	@Override
	public void accessMemoryObjects() {
		this.structuredTabularDataMO = (MemoryObject) this.getInput("STRUCTURED_TABULAR_DATA");
		this.gpsDataMO = (MemoryObject) this.getInput("GPS_DATA");
		this.outputAnalysisMO = (MemoryObject) this.getOutput("OUTPUT_ANALYSIS");
	}

	@Override
	public void calculateActivation() {
		// TODO Auto-generated method stub
	}

	@Override
	public void proc() {
		synchronized (outputAnalysisMO) {
			if (structuredTabularDataMO.getI() != null && gpsDataMO.getI() != null) {
				outputAnalysisMO.setI(gpsDataMO.getI());
				System.out.print("Results: ");
				System.out.println(outputAnalysisMO.getI());
			}
		}
	}
}
