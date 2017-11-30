package project;

import project.Environment;
import project.Mission;
import project.Point;

/**
 * 
 * @param mission 
 * @param environment 
 * @return 
 * @param type 
 */
public class StrategyNNPath extends AbstractStrategy {
	
	public StrategyNNPath() {
		super();
	}
	
	public Position calculateNextPoint(Position[] unvisitedPoints, Environment environment, int nextPositionIndex, Position currentPosition) {
		Position[] points = unvisitedPoints; 
		if(points.length == 0) return null;
		//For the assignement
		//If the target room (next point) has more than 1 rover, then wait or return the rover position
		//Else go to the target room
		
		int closestPoint = 0; //First point in the array of unvisited points.
		for(int index = 1; index < points.length; index++)
			if(currentPosition.getDistance(points[index]) < currentPosition.getDistance(points[closestPoint])) {
				closestPoint = index;
			}
		return points[closestPoint];//Do stuff Nearest Neighbor Path 
		
		// Assignement 1 test
		/*switch(type) {
			case NNPath: 
				int closestPoint = 0; //First point in the array of unvisited points.
				for(int index = 1; index < points.length; index++)
					if(currentPosition.getDistance(points[index]) < currentPosition.getDistance(points[closestPoint])) {
						closestPoint = index;
					}
				return points[closestPoint];//Do stuff Nearest Neighbor Path 
			case InMissionOrder:
				return points[0]; //Probably this we should use in the first mission because the order we visit the points in is very important.
			case optimizeTime: return points[0];//Do stuff
		default: return null;
		}	*/
	}
};
