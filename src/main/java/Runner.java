package main.java;

import java.io.IOException;

import architecture.Architecture;
import interpretables.dataLogs.*;

public class Runner {

	public static void main(String[] args) throws IOException { 
		Codelet c = new Codelet();
		DataLog dataLog = new DataLogTemplateReader("C:\\Users\\danie\\eclipse-workspace\\IC_HIAAC\\log1.txt");
		dataLog.printLog();
		
		//Architecture mainArchitecture = new Architecture();
		//mainArchitecture.runLog(dataLog);
	}

}
