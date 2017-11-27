package project;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import project.AbstractSimulatorMonitor;
import project.Point;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class User {

	public static void main(String[] args) throws InterruptedException {

		EnvironmentDescription e = new EnvironmentDescription();
		
		Color c = Color.GRAY;

		Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, e, c);

		Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, e, c);

		Boundary w3 = new VerticalBoundary(5.0f, -5.0f, -3.0f, e, c);

		Boundary w4 = new VerticalBoundary(5.0f, -2.0f, 2.0f, e, c);
		
		Boundary w5 = new VerticalBoundary(5.0f, 3f, 5.0f, e, c);
		
		Boundary w6 = new VerticalBoundary(-5.0f, -5.0f, -3.0f, e, c);

		Boundary w7 = new VerticalBoundary(-5.0f, -2.0f, 2.0f, e, c);
		
		Boundary w8 = new VerticalBoundary(-5.0f, 3f, 5.0f, e, c);
		//create four rooms with doors
		
		AbstractWall roomWall2 = new HorizontalWall(0f, -2.0f, 2f, e, c);

		AbstractWall roomWall3 = new VerticalWall(0f, -2f, 2f, e, c);
		
		AbstractWall roomWall5 = new HorizontalWall(0f, 5.0f, 3.0f, e, c);

		AbstractWall roomWall6 = new HorizontalWall(0f, -5.0f, -3.0f, e, c);

		AbstractWall roomWall7 = new VerticalWall(0f, 5f, 3f, e, c);

		AbstractWall roomWall8 = new VerticalWall(0f, -5f, -3f, e, c);

		Position exit1 = new Position(2.5,-7);
		Position exit2 = new Position(2.5,7);
		Position exit3 = new Position(-2.5,7);
		Position exit4 = new Position(-2.5,-7);
		
		Set<Rover> rovers = new HashSet<>();
		Rover rover1 = new Rover(exit1, "Rover 1");
		Rover rover2 = new Rover(exit2, "Rover 2");
		Rover rover3 = new Rover(exit3, "Rover 3");
		Rover rover4 = new Rover(exit4, "Rover 4");
		
		Position room1 = new Position(2.5,-2.5);
		Position room2 = new Position(2.5, 2.5);
		Position room3 = new Position(-2.5,2.5);
		Position room4 = new Position(-2.5,-2.5);
		
		LocationController room1Ctrl = new LocationController(room1, 2.5, e);
		LocationController room2Ctrl = new LocationController(room2, 2.5, e);
		LocationController room3Ctrl = new LocationController(room3, 2.5, e);
		LocationController room4Ctrl = new LocationController(room4, 2.5, e);
		
		Mission mission1 = new Mission(rover1, new Position[]{exit1,room1,room2,exit2});
		Mission mission2 = new Mission(rover2, new Position[]{exit2,room2,room3,exit3});
		Mission mission3 = new Mission(rover3, new Position[]{exit3,room3,room4,exit4});
		Mission mission4 = new Mission(rover4, new Position[]{exit4,room4,room1,exit1});

		rovers.add(rover1);
		rovers.add(rover2);
		rovers.add(rover3);
		rovers.add(rover4);
		
		AbstractSimulatorMonitor controller = new SimulatorMonitor(rovers, e);
		
		System.out.println(rover1.getPosition().toString());
		
		while(true) {
			System.out.println(mission3.getMissionStatus());
			if(mission1.getMissionStatus() && mission3.getMissionStatus()) {
				mission2.updateRoverPosition(mission2.getNextPosition());
				mission4.updateRoverPosition(mission4.getNextPosition());
			} else {
				mission1.updateRoverPosition(mission1.getNextPosition());
				mission3.updateRoverPosition(mission3.getNextPosition());
			}
			
		}

	}

}
