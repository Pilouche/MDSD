// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package project;

import java.util.Arrays;

import project.Position;

/************************************************************/
/**
 * 
 */
public class Mission implements RoverObserver{
	/**
	 * 
	 */
	public Mission(Rover r, Position[] positions, AbstractStrategy strat) {
		this.setMission(positions);
		this.rover = r;
		nextPositionIndex = 0;
		nextPosition = missionPoints[nextPositionIndex];
		strategy = strat;
		r.observe(this);
		nextPosition = rover.getPosition();
	}

	private Position nextPosition;
	//public StrategyType[] strategyType;
	//private AbstractStrategy strategy = AbstractStrategy.getInstance();
	private Position[] missionPoints;
	private Position[] unvisitedPoints;
	private Rover rover;
	private int nextPositionIndex;
	private boolean missionStatus;
	private AbstractStrategy strategy;

	/**
	 * 
	 * @param points 
	 */
	public void setMission(Position[] position) {
		missionPoints = position;
		unvisitedPoints = position;
	}

	/**
	 * 
	 */
	public void stopMission() {
		missionStatus = true;
		//System.out.println("Stopping " + missionStatus);
	}

	public void startMission() {
		missionStatus = false;
		//System.out.println("starting " + missionStatus);
	}

	public void addPosition(Position addedPos) {
		missionPoints = addPointToArray(missionPoints, addedPos);
		unvisitedPoints = addPointToArray(unvisitedPoints, addedPos);
	}

	public void removePosition(Position removedPos) {
		unvisitedPoints = removePointFromArray(unvisitedPoints, removedPos);
		missionPoints = removePointFromArray(missionPoints, removedPos);
	}

	public void removePosition(int removedPos) {
		if(removedPos < unvisitedPoints.length) {
			removePosition(unvisitedPoints[removedPos]);
		}
	}

	public void updateRoverPosition(Position newPos, String name) {
		//System.out.println(rover.getPosition().toString());
		//System.out.println(nextPosition.getX() == newPos.getX() && (nextPosition.getZ() == newPos.getZ()));
		//if(rover.isAtPosition(newPosition)) {
		if((((nextPosition.getX() + 0.1 >= newPos.getX() && nextPosition.getX() - 0.1 <= newPos.getX()) 
				&& (nextPosition.getZ() + 0.1 >= newPos.getZ() && nextPosition.getZ() - 0.1 <= newPos.getZ())) 
				&& !missionStatus) || nextPosition == null) {
			if(unvisitedPoints.length == 0) {
				missionStatus = true;
			} else {
				//nextPositionIndex++;
				nextPosition = strategy.calculateNextPoint(unvisitedPoints, rover.inEnvironment, nextPositionIndex, nextPosition, rover);
				rover.moveToPoint(nextPosition);

				unvisitedPoints = removePointFromArray(unvisitedPoints, nextPosition);
			}
		}
	}

	public Position getNextPosition() {
		return nextPosition;
	}
	public Position[] getMissionPoints() {
		return missionPoints;
	}
	public Position[] getUnvisitedPoints() {
		return unvisitedPoints;
	}

	public boolean getMissionStatus() {
		return missionStatus;
	}
	public void setStrategy(AbstractStrategy strat) {
		this.strategy = strat;
	}
	
	public AbstractStrategy getStrategy() {
		return this.strategy;
	}

	private Position[] addPointToArray(Position[] array, Position addedPos) {
		Position[] tempPositionArray = new Position[array.length + 1];
		for(int x = 0; x < array.length; x++) {
			tempPositionArray[x] = missionPoints[x];
		}
		tempPositionArray[array.length] = addedPos;
		return tempPositionArray;
	}
	
	private Position[] removePointFromArray(Position[] array, Position removedPos) {
		boolean pointExistedInArray = false;
		Position tempArray[] = new Position[0];
		if(array.length-1>0) {
			tempArray = new Position[array.length-1];
		}

		//Should probably be changed to some utility package or moved to some 
		//helper class we make code in as we need it. Basically just ArrayUtils.RemoveElement
		int y = 0;
		for(int x = 0; x < array.length; x++) {

			if(array[x].equals(removedPos)) {
				//System.out.println("removed visited point at index " + x);
				if(x+1<array.length)
				x++;
				pointExistedInArray = true;
			}

			if(y < array.length-1) {
				tempArray[y] = array[x];
			}
			y++;
		}
		
		if(pointExistedInArray) {
			return tempArray;
		} else {
			return array;
		}
	}
};
