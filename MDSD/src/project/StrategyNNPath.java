package project;

import area.Environment;
import area.EnvironmentAdapter;
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

	public Position calculateNextPoint(Position[] unvisitedPoints, EnvironmentAdapter environment, int nextPositionIndex,
			Position currentPosition, Rover r) {
		Position[] points = unvisitedPoints;
		if (points.length == 0)
			return null;
		// For the assignement
		// If the target room (next point) has more than 1 rover, then wait or return
		// the rover position
		// Else go to the target room

		int closestPoint = 0; // First point in the array of unvisited points.
		for (int index = 1; index < points.length; index++)
			if (currentPosition.getDistance(points[index]) < currentPosition.getDistance(points[closestPoint])) {
				closestPoint = index;
			}
		return points[closestPoint];// Do stuff Nearest Neighbor Path

	}

	@Override
	public void calculateWholePath(Environment environment, Position currentPosition, Rover r) {
		// TODO Auto-generated method stub
		
	}
};
