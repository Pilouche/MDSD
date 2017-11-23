// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package project;

import java.util.HashSet;
import java.util.Set;

import project.Area;
import project.Rover;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

/************************************************************/
/**
 * 
 */
public class Environment {
	/**
	 * 
	 */
	private EnvironmentDescription envDesc;
	/**
	 * 
	 */
	private Set<Boundary> boundaries;
	/**
	 * 
	 */
	private Set<Wall> walls;
	/**
	 * 
	 */
	public Area area;
	/**
	 * 
	 */
	public Rover[] rovers;
	
	public Environment(EnvironmentDescription e, Set<Boundary> b, Set<Wall> w, Rover[] r) {
		this.rovers=r;
		this.walls=w;
		this.boundaries=b;
		this.envDesc=e;
	}

	/**
	 * 
	 * @param boundaries 
	 */
	public void setBoundaries(Set<Boundary> boundaries) {
		this.boundaries=boundaries;
	}

	/**
	 * 
	 *
	 */
	public Set<Boundary> getBoundaries() {
		return boundaries;
	}
	
	/**
	 * 
	 * @param walls 
	 */
	public void setWalls(Set<Wall> walls) {
		this.walls=walls;
	}

	/**
	 * 
	 * 
	 */
	public Set<Wall> getWalls() {
		return walls;
	}
};
