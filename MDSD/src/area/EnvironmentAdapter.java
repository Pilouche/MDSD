// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package area;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import project.Mission;
import project.Position;
import project.Rover;

/************************************************************/
/**
 * 
 */
public abstract class EnvironmentAdapter extends EnvironmentAdaptee implements Environment{

	/**
	 * 
	 */
	protected Set<Position> positions;
	private Set<Area> areas;
	protected Set<Rover> rovers = new HashSet<>();
	protected Mission[] missions = new Mission[4];

	
	public EnvironmentAdapter() {
		super();
		areas = new HashSet<>();
	}

	/**
	 * 
	 * @param boundaries 
	 */
	public void setPositions(Set<Position> positions) {
		this.positions=positions;
	}

	/**
	 * 
	 *
	 */
	public Set<Position> getPositions() {
		return positions;
	}
	
	public Set<Area> getAreas(){
		return areas;
	}
	
	public void addArea(Area a) {
		areas.add(a);
	}
	
	public Set<Rover> getRovers() {
		return rovers;
	}
	
	public Mission[] getMissions() {
		return missions;
	}
	
	public void addBoundry(float p1, float p2, float length, EnvironmentAdaptee e, Color c, boolean horizontal) {
		super.addBoundry(p1, p2, length, e, c, horizontal);
	}
	
	public void addWall(float p1, float p2, float length, EnvironmentAdaptee e, Color c, boolean horizontal) {
		super.addWall(p1, p2, length, e, c, horizontal);
	}
	
	
};
