// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import area.Environment;
import project.Position;

/************************************************************/
/**
 * 
 */
public class Rover extends RobotAvatar {
	
	private Position position;
	private Position cachedMissionPoint;
	/**
	 * 
	 */
	private int rewardPoints;
	/**
	 * 
	 */
	public Environment inEnvironment;
	private List<RoverObserver> obs;
	private Set<LocationController> locks = new HashSet<LocationController>();
	private LocationController nextPosLock;
	
	public Rover(Position position, String name, Environment e) {
		super(position, name);
		this.position = position;
		obs = new ArrayList<RoverObserver>();
		this.inEnvironment=e;
	}

	/**
	 * 
	 * @return 
	 */
	public int getRewardPoints() {
		return rewardPoints;
	}

	/**
	 * 
	 * @param points 
	 */
	public void addRewardPoints(int points) {
		rewardPoints += points; 
	}

	/**
	 * 
	 * @param point 
	 */
	public void moveToPoint(Position pos, boolean missionPoint) {
		this.setDestination(pos);
		if(missionPoint) {
			cachedMissionPoint = pos;
		}
		//System.out.println(this.getName() + pos.toString());
		if(pos.hasLock()){
			nextPosLock = pos.getLock();
			if(nextPosLock.isInsideRadius(this)) {
				if(nextPosLock.tryAcquire(this)) {
					locks.add(nextPosLock);
					System.out.println(this.getName() + " Successfully acquired a lock");
				}else {
					//System.out.println(this.getName() + " is inside the area but failed to acquire a lock");
				}
			}
			//position.getLock().tryAcquire(this);
		}
		//System.out.println("Rover: " + super.getName() + " Moving to: " + pos.getX() + ", " + pos.getZ());
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public Environment getEnvironment() {
		return this.inEnvironment;
	}
	
	public void observe(RoverObserver obs) {
		this.obs.add(obs);
	}
	
	public void removeObserver(RoverObserver obs) {
		this.obs.remove(obs);
	}

	public void update() {
		//System.out.println("Updating rover");
		Position newPosition = new Position(super.getPosition().getX(), super.getPosition().getZ());
		//if(newPosition.getX() != position.getX() || newPosition.getZ() != position.getZ()) {
			//System.out.println("New position: " + newPosition.toString());
			position = newPosition;
			for(RoverObserver o : obs) {
				o.updateRoverPosition(position, super.getName());
			}
			
			if(!locks.contains(nextPosLock) && nextPosLock.isInsideRadius(this)) {
				if(nextPosLock.tryAcquire(this)) {
					locks.add(nextPosLock);
				}else {
					//System.out.println(this.getName() + " is inside the area but failed to acquire a lock");
					moveToPoint(getPosition(), false);
					/*At this point the rover reached the border of the lock radius but could not acquire the area and should stop*/
				}
			}
			
			//this is a quick fix since setting each lock as a RoverObserver fucked with me more than I felt like handling
			//ideally this should be handled in the LocationControllers updateRoverPosition() but that crashed the sim.
			for(LocationController lock : locks) {
				if(!lock.isInsideRadius(this)) {
					lock.release(this);
					locks.remove(lock);
				}
			}
		//}
	}
	
};
