package project;

import area.*;

public class HospitalProcedure implements ProcedureType {

	private static final int PROCEDURE_A = 1;
	private static final int PROCEDURE_B = 2;
	
	private int currentProcedure = PROCEDURE_A;

	@Override
	public void calculateRewards(Rover rover) {
		Environment rovEnv = rover.getEnvironment();
		
		if(rovEnv == null) return;
		if(rovEnv.getAreas() == null) return;
		
		//TODO: fix the point calculation when area and environment classes are done
		for(Area a : rovEnv.getAreas()) {
			if(a == null) return;
			if(a.getClass().equals(ConsultingRoom.class)) {
				rover.addRewardPoints(10);
			}
			
			if(a.getClass().equals(SurgeryRoom.class)) {
				rover.addRewardPoints(20);
			}
			
			if(a.getClass().equals(WiFi.class)) {
				rover.addRewardPoints(10);
			}
			
			if(a.getClass().equals(EatingArea.class)) {
				rover.addRewardPoints(10);
			}
		}
		
	}

}
