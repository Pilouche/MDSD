// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package area;

import java.util.HashSet;
import java.util.Set;

import project.Position;
import project.Rover;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Boundary;

/************************************************************/
/**
 * 
 */
public class Environment extends EnvironmentDescription{

	/**
	 * 
	 */
	protected Set<Position> positions;
	private Set<Area> areas;
	public Rover[] rovers;
	
	public Environment() {
		super();
	}
	
	public Environment(Set<Position> p, Set<Area> a, Rover[] r) {
		this.rovers=r;
		this.areas=a;
		this.positions=p;
	}

	/**
	 * 
	 * @param boundaries 
	 */
	public void setBoundaries(Set<Position> positions) {
		this.positions=positions;
	}

	/**
	 * 
	 *
	 */
	public Set<Position> getBoundaries() {
		return positions;
	}
	
	public Set<Area> getAreas(){
		return areas;
	}
	
	public void addArea(Area a) {
		areas.add(a);
	}
};
