package project;

import simbad.sim.EnvironmentDescription;

public class LocationController implements RoverObserver {

	Point pos;
	Double radius;
	EnvironmentDescription ed;
	boolean available;
	Rover activeBot;
	Point roverPos; 
	
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
	public LocationController(Point pos , double radius , EnvironmentDescription ed) {
		this.pos = pos;
		this.radius = radius;
		this.ed = ed;
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
		if (getEuclidDist(rover.getPosition()) < radius) {
			return false;
		}
		if (available){
			available = false;
			activeBot = rover;
			rover.observe(this);
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
		activeBot.removeObserver(this);
		available = true;
		activeBot = null;
		roverPos = null;
	}
	
	private double getEuclidDist(Point p) {
		return Math.sqrt(Math.pow(p.getX()-pos.getX(), 2)
				+Math.pow(p.getZ()-pos.getZ(), 2));
	}
	
	@Override
	public void updateRoverPosition(Position newPosition, String name) {
		roverPos = newPosition;
		if(getEuclidDist(newPosition) > radius) {
			release(activeBot);
		}
	}
}
