package project;

import area.Area;
import area.LogicalArea;
import area.PhysicalArea;

public class HospitalProcedure implements ProcedureType {

	private static final int PROCEDURE_A = 1;
	private static final int PROCEDURE_B = 2;
	
	private int currentProcedure = PROCEDURE_A;

	@Override
	public void calculateRewards(Rover rover) {
		Environment rovEnv = rover.getEnvironment();
		
		//TODO: fix the point calculation when area and environment classes are done
		for(Area a : rovEnv.getAreas()) {
			if(a.getClass().equals(PhysicalArea.class)) {
				rover.addRewardPoints(10);
			}
			
			if(a.getClass().equals(LogicalArea.class)) {
				rover.addRewardPoints(10);
			}
		}
		
	}

}
