// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package project;

import java.util.Set;

import area.Area;
import area.LogicalArea;
import area.PhysicalArea;
import project.ProcedureType;

/************************************************************/
/**
 * 
 */
public class Procedure extends Thread {
	/**
	 * 
	 */
	private Set<Rover> rovers;
	private ProcedureType type;
	
	public Procedure(Set<Rover> rovers, ProcedureType type) {
		this.rovers = rovers;
		this.type = type;
	}
	

	/**
	 *  
	 */
	@Override
	public void run() {
		
		while(true) {
		
			try {
				this.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			for(Rover rover : rovers) {
				type.calculateRewards(rover);
			}
		}

	}
	
	public void changeProcedureType(ProcedureType newType) {
		this.type = newType;
	}
};
