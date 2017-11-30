// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package project;


import project.Environment;
import project.Mission;
import project.Point;

/************************************************************/
/**
 * 
 */
public abstract class AbstractStrategy {
	
	public AbstractStrategy() {}
	/**
	 * 
	 * @param mission 
	 * @param environment 
	 * @return 
	 * @param type 
	 */
	
	public abstract Position calculateNextPoint(Position[] unvisitedPoints, Environment environment, int nextPositionIndex, Position currentPosition);
	
};
