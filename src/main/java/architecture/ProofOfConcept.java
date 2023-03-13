package main.java.architecture;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryObject;
import br.unicamp.cst.core.entities.Mind;
import codelets.LogGPSSensoryCodelet;
import codelets.LogStructuredTabularSensoryCodelet;
import codelets.LogReaderCodelet;
import codelets.ChurnPredictorCodelet;
import main.java.interpretables.dataLogs.DataLog;

public class ProofOfConcept extends Mind {

	private MemoryObject dataPackInputMO;
	private MemoryObject structuredTabularDataMO;
	private MemoryObject gpsDataMO;
	private MemoryObject outputAnalysisMO;

	public ProofOfConcept(DataLog dataLog) {
		super();
		
		dataPackInputMO = createMemoryObject("DATA_PACK_INPUT", null);
		
		structuredTabularDataMO = createMemoryObject("STRUCTURED_TABULAR_DATA", null); 
		
		int gpsRelevance = 0; // TODO: change analysis
		gpsDataMO = createMemoryObject("GPS_DATA", gpsRelevance); 
		
		outputAnalysisMO = createMemoryObject("OUTPUT_ANALYSIS", 0);

	    createMemoryGroup("ProofOfConceptMemoryGroup");
	    createCodeletGroup("ProofOfConceptCodeletGroup");

	    registerMemory(dataPackInputMO, "ProofOfConceptMemoryGroup");
	    registerMemory(structuredTabularDataMO, "ProofOfConceptMemoryGroup");
	    registerMemory(gpsDataMO, "ProofOfConceptMemoryGroup");
	    registerMemory(outputAnalysisMO, "ProofOfConceptMemoryGroup");
		
	    Codelet logReader = new LogReaderCodelet(dataLog);
	    logReader.addOutput(dataPackInputMO);
        insertCodelet(logReader);
        
		Codelet logGPSSensor = new LogGPSSensoryCodelet(dataPackInputMO);
		logGPSSensor.addInput(dataPackInputMO);
		logGPSSensor.addOutput(gpsDataMO);
		//logGPSSensor.setIsMemoryObserver(true);
		//gpsDataMO.addMemoryObserver(logGPSSensor);
        insertCodelet(logGPSSensor);
        
		Codelet logStructuredTabularSensor = new LogStructuredTabularSensoryCodelet(dataPackInputMO);
		logStructuredTabularSensor.addInput(dataPackInputMO);
		logStructuredTabularSensor.addOutput(structuredTabularDataMO);
		//logStructuredTabularSensor.setIsMemoryObserver(true);
		//structuredTabularDataMO.addMemoryObserver(logStructuredTabularSensor);
        insertCodelet(logStructuredTabularSensor);
        
		Codelet analysisPerception = new ChurnPredictorCodelet();
		analysisPerception.addInput(structuredTabularDataMO);
		analysisPerception.addInput(gpsDataMO);
		analysisPerception.addOutput(outputAnalysisMO);
		//analysisPerception.setIsMemoryObserver(true);
		//structuredTabularDataMO.addMemoryObserver(analysisPerception);
		//gpsDataMO.addMemoryObserver(analysisPerception);
        insertCodelet(analysisPerception);

        registerCodelet(logGPSSensor, "ProofOfConceptCodeletGroup");
        registerCodelet(logStructuredTabularSensor, "ProofOfConceptCodeletGroup");
        registerCodelet(analysisPerception, "ProofOfConceptCodeletGroup");
        registerCodelet(logReader, "ProofOfConceptCodeletGroup");
        
        // Sets a time step for running the codelets to avoid heating too much your machine
        for (Codelet c : this.getCodeRack().getAllCodelets()) {
            c.setTimeStep(1);
        }

		start();
	}
}
