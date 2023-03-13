package main.java;

import main.java.architecture.ProofOfConcept;
import main.java.interpretables.dataLogs.*;

import java.io.IOException;

import br.unicamp.cst.core.entities.Mind;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		String pathString = "C:\\Users\\danie\\eclipse-workspace\\IC_HIAAC\\log1.txt";
		
		DataLog dataLog = new DataLogTemplateReader(pathString);
		dataLog.printLog();
		
		Mind mainArchitecture = new ProofOfConcept(dataLog);
		
		System.out.println("Ended Program");
		
		while(true) {
			;
		}
	}

}
