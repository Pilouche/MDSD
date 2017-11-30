package project;

import java.util.Set;

import project.AbstractRobotSimulator;
import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<Rover> {

	public SimulatorMonitor( Set<Rover> rovers, EnvironmentDescription e) {
		super(rovers, e);
	}
	
	@Override
	public void update(Rover rover) {
		rover.update();
	}

}
