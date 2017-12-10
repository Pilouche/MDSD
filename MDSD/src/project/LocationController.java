package project;

import simbad.sim.EnvironmentDescription;

public class LocationController implements RoverObserver{

	private Point pos;
	private Double radius;
	private boolean available;
	private Rover activeBot;
	private Point roverPos; 
	
	/**
	* CONSTRUCTOR
	* Creates a new location controller at a specified
	* point working within a given radius in
	* a given environment
	*
	* @param pos
	* the position of the controller
	* @param radius
	* the radius within which it is
	* possible to communicate
	* with the controller
	* @param wd
	* the environment
	*/
	public LocationController(Point pos , double radius) {
		this.pos = pos;
		this.radius = radius;
		available = true;
	}
	/**
	* Try to get a permission to enter the area .
	* The method should only be called
	* by a robot within range .
	*
	* @param rover
	* the robot
	* @return true if successful , false if unsuccessful
	*/
	public synchronized boolean tryAcquire(Rover rover){
		if (getEuclidDist(rover.getPosition()) > radius) {
			System.out.println("failed due to being outside of the locks radius");
			return false;
		}
		if (available){
			available = false;
			activeBot = rover;
			//rover.observe(this);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	* Release the permission after having left the area .
	* The method should only be called by a robot within
	* the range that currently holds the permission .
	* @param a
	7
	* the robot
	*/
	public void release(Rover a) {
		System.out.println("lock released for rover: " + activeBot.getName());
		//activeBot.removeObserver(this); //the thread crashed with these as observers, moved the same logic to each rovers update
		available = true;
		activeBot = null;
		roverPos = null;
	}
	
	public double getEuclidDist(Point p) {
		return Math.sqrt(Math.pow(p.getX()-pos.getX(), 2)
				+Math.pow(p.getZ()-pos.getZ(), 2));
	}
	
	
	/*Should be called automatically by the active rover and thus release when the rover moves outside of the radius
	 * This crashed the simulator so I made the rover do the check and call release manually instead */
	@Override
	public void updateRoverPosition(Position newPosition, String name) {
		roverPos = newPosition;
		if(getEuclidDist(newPosition) > radius) {
			release(activeBot);
		}
	}
	public boolean isAvailable() {
		return available;
	}
	
	public boolean isInsideRadius(Rover rover) {
		return getEuclidDist(rover.getPosition()) < radius;
	}
}
