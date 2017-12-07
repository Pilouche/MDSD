package project;

import area.Area;
import area.Environment;
import area.LogicalArea;
import area.PhysicalArea;

public class NormalProcedure implements ProcedureType {
	
	private static final int PROCEDURE_A = 1;
	private static final int PROCEDURE_B = 2;
	
	private int currentProcedure = PROCEDURE_A;

	@Override
	public void calculateRewards(Rover rover) {
		boolean changeProcedure = false;
		
		
		
			Environment rovEnvironment = rover.getEnvironment();
			
			if(rovEnvironment == null) return;
			
			if(rovEnvironment.getAreas() == null) return;
			for(Area a: rovEnvironment.getAreas()) {
				if(a == null) return;
				if(currentProcedure == PROCEDURE_A) {
					if(a.getClass().equals(PhysicalArea.class)) {
						rover.addRewardPoints(1);
					} else if(a.getClass().equals(LogicalArea.class)) {
						changeProcedure = true;
					}
				}
				else if(currentProcedure == PROCEDURE_B) {
					if(a.getClass().equals(PhysicalArea.class)) {
						changeProcedure = true;
					} else if(a.getClass().equals(LogicalArea.class)) {
						rover.addRewardPoints(1);
					}
				}
			}
	
	
	if(changeProcedure && currentProcedure == PROCEDURE_A) {
		currentProcedure = PROCEDURE_B;
	} else if(changeProcedure && currentProcedure == PROCEDURE_B) {
		currentProcedure = PROCEDURE_B;
	}
	changeProcedure=false;
	}

}
