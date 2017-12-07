package project;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import area.Area;
import area.Environment;
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
		University h = new University();
		Position[] exits = h.getExits().toArray(new Position[0]);
		Position[] rooms = h.getRooms().toArray(new Position[0]);
		Rover[] rovers= h.getRovers().toArray(new Rover[0]);
		
		LocationController room1Ctrl = new LocationController(rooms[0], 2.5, h);
		LocationController room2Ctrl = new LocationController(rooms[1], 2.5, h);
		LocationController room3Ctrl = new LocationController(rooms[2], 2.5, h);
		LocationController room4Ctrl = new LocationController(rooms[3], 2.5, h);
		
		AbstractSimulatorMonitor controller = new SimulatorMonitor(h.getRovers(), h);
		
		Mission[] missions = {new Mission(rovers[0], new Position[]{exits[0],rooms[0],rooms[1],exits[1]}, new StrategyInMissionOrder()),
		new Mission(rovers[1], new Position[]{exits[1],rooms[1],rooms[2],exits[2]}, new StrategyInMissionOrder()),
		new Mission(rovers[2], new Position[]{exits[2],rooms[2],rooms[3],exits[3]}, new StrategyInMissionOrder()),
		new Mission(rovers[3], new Position[]{exits[3],rooms[3],rooms[0],exits[0]}, new StrategyInMissionOrder())};
		
		User u = new User(h.getRovers(), missions);
		
		u.setRovers(h.getRovers());
		
		Procedure p = new Procedure(h.getRovers(), new NormalProcedure());
		p.start();
		
		System.out.println(rovers[0].getPosition().toString());
		
		/*
		while(true) {
			for(Area a : areas) {
				if (a.contains(rover1.getPosition())) {
					System.out.println("Rover 1 in " + a);
				}
			}
		}*/
		
		/**
		while(true) {
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
