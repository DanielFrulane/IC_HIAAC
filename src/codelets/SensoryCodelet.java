package codelets;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.MemoryObject;
import main.java.interpretables.DataPack;

public abstract class SensoryCodelet extends Codelet {

	MemoryObject dataPackInputMO;
	
	public SensoryCodelet(MemoryObject dataPackInputMO) {
		this.dataPackInputMO = dataPackInputMO;
	}

}
