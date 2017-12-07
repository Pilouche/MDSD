package area;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import project.LocationController;
import project.Position;
import project.Rover;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class University extends Environment{

	Set<Position> exits = new HashSet<>();
	Set<Position> rooms = new HashSet<>();
	Set<Rover> rovers = new HashSet<>();
	
	public University() {
		super();
		Color c = Color.GRAY;

		Position p1 = new Position(-5,5);
		Position p2 = new Position(-5,0);
		Position p3 = new Position(-5,-5);
		Position p4 = new Position(0,5);
		Position p5 = new Position(0,0);
		Position p6 = new Position(0,-5);
		Position p7 = new Position(5,5);
		Position p8 = new Position(5,0);
		Position p9 = new Position(5,-5);

		Set<Position> roomA = new HashSet<>();
		roomA.add(p1);roomA.add(p2);roomA.add(p5);roomA.add(p4);
		Area a1 = new PhysicalArea(roomA);
		this.addArea(a1);

		Set<Position> roomB = new HashSet<>();
		roomB.add(p2);roomB.add(p3);roomB.add(p6);roomB.add(p5);
		Area a2 = new PhysicalArea(roomB);
		this.addArea(a2);

		Set<Position> roomC = new HashSet<>();
		roomC.add(p4);roomC.add(p5);roomC.add(p8);roomC.add(p7);
		Area a3 = new PhysicalArea(roomC);
		this.addArea(a3);

		Set<Position> roomD = new HashSet<>();
		roomD.add(p5);roomD.add(p6);roomD.add(p9);roomD.add(p8);
		Area a4 = new PhysicalArea(roomD);
		this.addArea(a4);	

		Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, this, c);

		Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, this, c);

		Boundary w3 = new VerticalBoundary(5.0f, -5.0f, -3.0f, this, c);

		Boundary w4 = new VerticalBoundary(5.0f, -2.0f, 2.0f, this, c);

		Boundary w5 = new VerticalBoundary(5.0f, 3f, 5.0f, this, c);

		Boundary w6 = new VerticalBoundary(-5.0f, -5.0f, -3.0f, this, c);

		Boundary w7 = new VerticalBoundary(-5.0f, -2.0f, 2.0f, this, c);

		Boundary w8 = new VerticalBoundary(-5.0f, 3f, 5.0f, this, c);
		//create four rooms with doors

		AbstractWall roomWall2 = new HorizontalWall(0f, -2.0f, 2f, this, c);

		AbstractWall roomWall3 = new VerticalWall(0f, -2f, 2f, this, c);

		AbstractWall roomWall5 = new HorizontalWall(0f, 5.0f, 3.0f, this, c);

		AbstractWall roomWall6 = new HorizontalWall(0f, -5.0f, -3.0f, this, c);

		AbstractWall roomWall7 = new VerticalWall(0f, 5f, 3f, this, c);

		AbstractWall roomWall8 = new VerticalWall(0f, -5f, -3f, this, c);
		
		Position exit1 = new Position(2.5,-7);
		Position exit2 = new Position(2.5,7);
		Position exit3 = new Position(-2.5,7);
		Position exit4 = new Position(-2.5,-7);
		exits.add(exit1);
		exits.add(exit2);
		exits.add(exit3);
		exits.add(exit4);
		
		Position room1 = new Position(2.5,-2.5);
		Position room2 = new Position(2.5, 2.5);
		Position room3 = new Position(-2.5,2.5);
		Position room4 = new Position(-2.5,-2.5);
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		rooms.add(room4);
		
		Rover rover1 = new Rover(exit1, "Rover 1", this);
		Rover rover2 = new Rover(exit2, "Rover 2", this);
		Rover rover3 = new Rover(exit3, "Rover 3", this);
		Rover rover4 = new Rover(exit4, "Rover 4", this);
		
		rovers.add(rover1);
		rovers.add(rover2);
		rovers.add(rover3);
		rovers.add(rover4);
	}

	public University(Set<Position> p, Set<Area> a, Rover[] r) {
		super(p, a, r);
	}
	
	public Set<Position> getExits() {
		return exits;
	}
	
	public Set<Position> getRooms() {
		return rooms;
	}
	
	public Set<Rover> getRovers() {
		return rovers;
	}
}
