package codelets;

import br.unicamp.cst.core.entities.MemoryObject;
import main.java.interpretables.DataFormatEnum;
import main.java.interpretables.DataPack;
import main.java.interpretables.GPSData;

public class LogGPSSensoryCodelet extends SensoryCodelet {

	private MemoryObject gpsDataMO;

	public LogGPSSensoryCodelet(MemoryObject dataPackInputMO) {
		super(dataPackInputMO);
	}

	@Override
	public void accessMemoryObjects() {
		dataPackInputMO = (MemoryObject) this.getInput("DATA_PACK_INPUT");
		gpsDataMO = (MemoryObject) this.getOutput("GPS_DATA");
	}

	@Override
	public void calculateActivation() {
		;		
	}
	
	@Override
	public void proc() {
		synchronized (gpsDataMO) {
			System.out.println("proc gps");
			DataPack dataPack = (DataPack) dataPackInputMO.getI();
			if (dataPack != null && dataPack.getDataFormat() == DataFormatEnum.GPS) {
				GPSData gpsData = (GPSData) dataPack;
	        	if (gpsData.getLatitude() != 0 && gpsData.getLongitude() != 0) {
	            	gpsDataMO.setI(gpsData.getLatitude() + gpsData.getLongitude());
	        	}
			}
		}
	}

}
