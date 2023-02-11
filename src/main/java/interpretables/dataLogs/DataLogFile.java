package interpretables.dataLogs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import interfaces.DataLogReader;

public abstract class DataLogFile extends DataLog implements DataLogReader {
	BufferedReader objectReader;
	String currentLine;
	int currentLineNumber;

	public DataLogFile(String filePath) throws IOException {
		super();
		currentLine = null;
		currentLineNumber = 0;
		
		try {
			objectReader = new BufferedReader(new FileReader(filePath));			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
	
	void interpretAllFile() throws IOException { // to be redefined by subclasses
		assignNextLine();
		while (currentLine != null) {
			currentLineNumber++;
			interpretLine();
		    assignNextLine();
		}
		endReading();
	}
	
	void interpretLine() { // to be redefined by subclasses
	    System.out.println(currentLine);
	}
	
	void assignNextLine() {
		try {
			currentLine = objectReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void endReading() throws IOException {
		try {
			objectReader.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
