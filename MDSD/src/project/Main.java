package project;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import area.Area;
import area.Environment;
import area.EnvironmentAdapter;
import area.Hospital;
import area.PhysicalArea;
import area.University;
import project.AbstractSimulatorMonitor;
import project.Point;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Environment e = new Hospital();
		Set<Rover> rovers = e.getRovers();
		Mission[] missions = e.getMissions();
	
		AbstractSimulatorMonitor controller = new SimulatorMonitor(rovers, (EnvironmentDescription) e);
	
		User u = new User(rovers, missions);
		
		/*
		while(truh) {
			for(Area a : areas) {
				if (a.contains(rover1.getPosition())) {
					System.out.println("Rover 1 in " + a);
				}
			}
		}*/
		
		/**
		while(truh) {
			System.out.println(mission3.getMissionStatus());
			if(mission1.getMissionStatus() && mission3.getMissionStatus()) {
				mission2.updateRoverPosition(mission2.getNextPosition());
				mission4.updateRoverPosition(mission4.getNextPosition());
			} else {
				mission1.updateRoverPosition(mission1.getNextPosition());
				mission3.updateRoverPosition(mission3.getNextPosition());
			}
			
		}**/

	}
	

}
