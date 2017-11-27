// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package project;

import project.Position;
import project.StrategyType;

/************************************************************/
/**
 * 
 */
class Mission {
	/**
	 * 
	 */
	public Mission(Rover r, Position[] positions) {
		this.setMission(positions);
		this.rover = r;
		nextPositionIndex = 0;
		nextPosition = missionPoints[nextPositionIndex];
	}

	private Position nextPosition;
	public StrategyType[] strategyType;
	private Strategy strategy = Strategy.getInstance();
	private Position[] missionPoints;
	private Rover rover;
	private int nextPositionIndex;

	/**
	 * 
	 * @param points 
	 */
	public void setMission(Position[] position) {
		missionPoints = position;
	}

	/**
	 * 
	 */
	public void stopMission() {
	}
		
	public void updateRoverPosition(Position newPosition) {
		System.out.println(rover.getPosition().toString());
		System.out.println(newPosition.toString());
		if(rover.isAtPosition(newPosition)) {
			nextPositionIndex++;
			nextPosition = strategy.calculateNextPoint(this, null, StrategyType.optimizeLength,nextPositionIndex);
			rover.moveToPoint(nextPosition);
		}
	}
	
	public Position getNextPosition() {
		return nextPosition;
	}
	public Position[] getMissionPoints() {
		return missionPoints;
	}
};
