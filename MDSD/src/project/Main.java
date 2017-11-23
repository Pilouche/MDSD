package project;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

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

		EnvironmentDescription e = new EnvironmentDescription();
		
		Color c = Color.GRAY;

		Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, e, c);

		Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, e, c);

		Boundary w3 = new VerticalBoundary(5.0f, -5.0f, 5.0f, e, c);

		Boundary w4 = new VerticalBoundary(-5.0f, -5.0f, 5.0f, e, c);

		//create four rooms with doors
		
		AbstractWall roomWall1 = new HorizontalWall(0f, 2.0f, 0f, e, c);

		AbstractWall roomWall2 = new HorizontalWall(0f, -2.0f, 0f, e, c);

		AbstractWall roomWall3 = new VerticalWall(0f, 2f, 0f, e, c);

		AbstractWall roomWall4 = new VerticalWall(0f, -2f, 0f, e, c);
		
		AbstractWall roomWall5 = new HorizontalWall(0f, 5.0f, 3.0f, e, c);

		AbstractWall roomWall6 = new HorizontalWall(0f, -5.0f, -3.0f, e, c);

		AbstractWall roomWall7 = new VerticalWall(0f, 5f, 3f, e, c);

		AbstractWall roomWall8 = new VerticalWall(0f, -5f, -3f, e, c);

		
		Set<RobotAvatar> robots = new HashSet<>();
		Rover robot1 = new Rover(new Position(0, 0), "Robot 1");
		Rover robot2 = new Rover(new Position(1, 3), "Robot 2");
		Rover robot3 = new Rover(new Position(1, 3), "Robot 3");
		Rover robot4 = new Rover(new Position(1, 3), "Robot 4");
		
		Position room1 = new Position(0,0);
		Position room2 = new Position(0,0);
		Position room3 = new Position(0,0);
		Position room4 = new Position(0,0);
		
		Mission mission1 = new Mission();
		Mission mission2 = new Mission();
		Mission mission3 = new Mission();
		Mission mission4 = new Mission();

		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		
		AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);

	}

}
