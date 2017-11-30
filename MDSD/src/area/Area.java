// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package area;

import project.Boundary;
import java.util.Set;

public abstract class Area {
	/**
	 * 
	 */
	private Set<Boundary> boundaries;
	
	public Area(Set<Boundary> boundaries) {
		this.boundaries = boundaries;
	}

	/**
	 * 
	 * @return boundaries
	 */
	public Set<Boundary> getBoundaries() {

		return this.boundaries;
	}

	/**
	 * 
	 * @param boundaries 
	 */
	public void setBoundaries(Set<Boundary> boundaries) {
		this.boundaries = boundaries;
	}
};