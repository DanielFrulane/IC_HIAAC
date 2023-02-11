package main.java;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.io.rest.TestCodelet;
import main.java.interpretables.dataLogs.*;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		Codelet codelet = new TestCodelet("test");
		DataLog dataLog = new DataLogTemplateReader("C:\\Users\\danie\\eclipse-workspace\\IC_HIAAC\\log1.txt");
		dataLog.printLog();
		return;
		//Architecture mainArchitecture = new Architecture();
		//mainArchitecture.runLog(dataLog);
	}

}
