package project;

import area.Environment;
import project.Mission;
import project.Point;

/**
 * 
 * @param mission 
 * @param environment 
 * @return 
 * @param type 
 */
public class StrategyInMissionOrder extends AbstractStrategy {
	
	public StrategyInMissionOrder() {
		super();
	}
	
	public Position calculateNextPoint(Position[] unvisitedPoints, Environment environment, int nextPositionIndex, Position currentPosition, Rover r) {
		Position[] points = unvisitedPoints; 
		if(points.length == 0) return null;
		//For the assignement
		//If the target room (next point) has more than 1 rover, then wait or return the rover position
		//Else go to the target room
		return points[0]; //Probably this we should use in the first mission because the order we visit the points in is very important.
	}
};