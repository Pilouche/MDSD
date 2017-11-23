package project;

import java.util.Set;

import project.AbstractRobotSimulator;
import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<Rover> {

	public SimulatorMonitor( Set<Rover> robots, EnvironmentDescription e) {
		super(robots, e);
	}

	@Override
	public void update(Rover rover) {
		//p.newGPSpositionChangeDetected(robot.getPosition ());
	}

}
