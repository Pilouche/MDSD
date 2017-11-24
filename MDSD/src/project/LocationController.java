package project;

import simbad.sim.EnvironmentDescription;

public class LocationController {

	Point pos;
	Double radius;
	EnvironmentDescription ed;
	boolean available;
	AbstractRobotSimulator activeBot;
	boolean toBeReleased;
	
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
	* @param a
	* the robot
	* @return true if successful , false if unsuccessful
	*/
	public synchronized boolean tryAcquire(AbstractRobotSimulator a){
		if (Math.sqrt(Math.pow(a.getPosition().getX()-pos.getX(), 2)
			+Math.pow(a.getPosition().getZ()-pos.getZ(), 2)) < radius) {
			return false;
		}
		if (available){
			available = false;
			activeBot = a;
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
	public void release(AbstractRobotSimulator a ) {
		//needs to listen for when activeBot leaves the radius to release as the javadoc describes it, thus toBeReleased
		if (a == activeBot){
			toBeReleased = true;
			available = false;
			activeBot = null;
		}
	}
	
	
	
}
