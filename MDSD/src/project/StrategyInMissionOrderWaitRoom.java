package project;

import area.Area;
import area.Environment;

public class StrategyInMissionOrderWaitRoom extends AbstractStrategy{
	private long time = -1;
	public StrategyInMissionOrderWaitRoom() {
		super();
	}
	
	

	@Override
	public void calculateWholePath(Environment environment, Position currentPosition, Rover r) {
			
			Position[] points = super.getAllMissionPoints(); 
			Area currentArea = null;
			Area nextArea = null;
			
			for(Area a : environment.getAreas()) {
				if (a.contains(r.getPosition())) {
					currentArea = a;
				} else if (a.contains(points[0])) {
					nextArea = a;
				}
			}
			
			
			if (currentArea != nextArea) {
				if (time ==-1) {
					time = System.nanoTime();
				}
				
				if(System.nanoTime()-time<Long.parseLong("2000000000")) {
					//return r.getPosition();
				} else {
					time = -1;
				}
				
				// this crashes
				/*
				try {
					r.wait(2000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			
			}
			//For the assignement
			//If the target room (next point) has more than 1 rover, then wait or return the rover position
			//Else go to the target room

	}

}
