package area;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import project.LocationController;
import project.Mission;
import project.Position;
import project.Rover;
import project.StrategyInMissionOrder;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;
import project.LocationController;
public class Hospital extends Environment{

	public Hospital() {
		super();
		this.rovers = new HashSet<>();
		this.missions = new Mission[4];
		Color c1 = Color.BLUE;
		Color c2 = Color.RED;

		Position p1 = new Position(-6,6);
		Position p2 = new Position(-6,0);
		Position p3 = new Position(-6,-6);
		Position p4 = new Position(-3,3);
		Position p5 = new Position(-3,0);
		Position p6 = new Position(-3,-3);
		Position p7 = new Position(0,6);
		Position p8 = new Position(0,3);
		Position p9 = new Position(0,-3);
		Position p10 = new Position(0,-6);
		Position p11 = new Position(3,3);
		Position p12 = new Position(3,0);
		Position p13 = new Position(3,-3);
		Position p14 = new Position(6,6);
		Position p15 = new Position(6,0);
		Position p16 = new Position(6,-6);
		
		SurgeryDivision sd1 = new SurgeryDivision(new HashSet<>(Arrays.asList(p1,p2,p3,p10,p9,p6,p5,p4,p8,p7)));
		SurgeryDivision sd2 = new SurgeryDivision(new HashSet<>(Arrays.asList(p7,p8,p11,p12,p13,p9,p10,p16,p15,p14)));
		EmergencyDivision ed = new EmergencyDivision(new HashSet<>(Arrays.asList(p4,p5,p6,p9,p13,p12,p11,p8)));
		
		Set<Position> sRoom1 = new HashSet<>();
		sRoom1.add(p1);sRoom1.add(p2);sRoom1.add(p5);sRoom1.add(p4);sRoom1.add(p8);sRoom1.add(p7);
		Area a1 = new SurgeryRoom(sRoom1,sd1);
		this.addArea(a1);

		Set<Position> sRoom2 = new HashSet<>();
		sRoom2.add(p2);sRoom2.add(p3);sRoom2.add(p10);sRoom2.add(p9);sRoom1.add(p6);sRoom1.add(p5);
		Area a2 = new SurgeryRoom(sRoom2,sd1);
		this.addArea(a2);

		Set<Position> sRoom3 = new HashSet<>();
		sRoom3.add(p7);sRoom3.add(p8);sRoom3.add(p11);sRoom3.add(p12);sRoom1.add(p15);sRoom1.add(p14);
		Area a3 = new SurgeryRoom(sRoom3,sd2);
		this.addArea(a3);

		Set<Position> sRoom4 = new HashSet<>();
		sRoom4.add(p9);sRoom4.add(p10);sRoom4.add(p16);sRoom4.add(p15);sRoom1.add(p12);sRoom1.add(p13);
		Area a4 = new SurgeryRoom(sRoom4,sd2);
		this.addArea(a4);	

		Set<Position> cRoom1 = new HashSet<>();
		cRoom1.add(p4);cRoom1.add(p6);cRoom1.add(p11);cRoom1.add(p13);
		Area a5 = new ConsultingRoom(cRoom1,ed);
		this.addArea(a5);	
		
		super.addBoundry(-6.0f, -6.0f, 6.0f, this, c2, true);
		
		super.addBoundry(6.0f, -6.0f, 6.0f, this, c2, true);

		super.addBoundry(6.0f, -6.0f, -3.5f, this, c2, false);

		super.addBoundry(6.0f, -2.5f, 2.5f, this, c2, false);

		super.addBoundry(6.0f, 3.5f, 6.0f, this, c2, false);

		super.addBoundry(-6.0f, -6.0f, -3.5f, this, c2, false);

		super.addBoundry(-6.0f, -2.5f, 2.5f, this, c2, false);

		super.addBoundry(-6.0f, 3.5f, 6.0f, this, c2, false);
		//create four rooms with doors

		super.addWall(3f, -2.25f, 2.25f, this, c1, true);

		super.addWall(3f, -2.25f, 2.25f, this, c1, false);
		
		super.addWall(-3f, -2.25f, 2.25f, this, c1, true);

		super.addWall(-3f, -2.25f, 2.25f, this, c1, false);

		super.addWall(0f, 6.0f, 4.0f, this, c2, true);

		super.addWall(0f, -6.0f, -4.0f, this, c2, true);

		super.addWall(0f, 6f, 4.0f, this, c2, false);

		super.addWall(0f, -6f, -4.0f, this, c2, false);

		double lockRadius = 2.0;

		Position room1 = new Position(5,-5, lockRadius);
		Position room2 = new Position(5, 5, lockRadius);
		Position room3 = new Position(-5,5, lockRadius);
		Position room4 = new Position(-5,-5, lockRadius);
		Position room5 = new Position(0,0, lockRadius);

		Rover rover1 = new Rover(room1, "Rover 1", this);
		Rover rover2 = new Rover(room2, "Rover 2", this);
		Rover rover3 = new Rover(room3, "Rover 3", this);
		Rover rover4 = new Rover(room4, "Rover 4", this);
		rovers.add(rover1);
		rovers.add(rover2);
		rovers.add(rover3);
		rovers.add(rover4);

		missions[0] = new Mission(rover1, new Position[]{room1,room5,room5,room1}, new StrategyInMissionOrder());
		missions[1] = new Mission(rover2, new Position[]{room2,room5,room5,room2}, new StrategyInMissionOrder());
		missions[2] = new Mission(rover3, new Position[]{room3,room5,room5,room3}, new StrategyInMissionOrder());
		missions[3] = new Mission(rover4, new Position[]{room4,room5,room5,room4}, new StrategyInMissionOrder());
	}
}
