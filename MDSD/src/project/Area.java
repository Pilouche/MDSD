// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package project;

import project.AreaType;
import project.Boundaries;

/************************************************************/
/**
 * 
 */
public abstract class Area {
	/**
	 * 
	 */
	private Boundaries boundaries;

	/**
	 * 
	 * @param areaType 
	 */
	public AreaType getAreaType() {
		return null; //Fix this
	}

	/**
	 * 
	 * @return 
	 */
	public Boundaries getBoundaries() {

		return this.boundaries;
	}

	/**
	 * 
	 * @param boundaries 
	 */
	public void setBoundaries(Boundaries boundaries) {
		this.boundaries = boundaries;
	}
};
