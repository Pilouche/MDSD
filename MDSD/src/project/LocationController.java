package project;

import simbad.sim.EnvironmentDescription;

public class LocationController {
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
	public LocationController(Point pos , double radius , EnvironmentDescription wd) {
		
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
	public boolean tryAcquire(AbstractRobotSimulator a){
		return false;
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
		
	}
}
