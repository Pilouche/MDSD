package project;

import area.Area;
import area.Environment;

public class StrategyInMissionOrderWaitRoom extends AbstractStrategy{
	private long time = -1;
	public StrategyInMissionOrderWaitRoom() {
		super();
	}
	
	public Position calculateNextPoint(Position[] unvisitedPoints, Environment environment, int nextPositionIndex, Position currentPosition, Rover r) {
		Position[] points = unvisitedPoints; 
		if(points.length == 0) return null;
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
				return r.getPosition();
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

		return points[0]; //Probably this we should use in the first mission because the order we visit the points in is very important.
	}

}
