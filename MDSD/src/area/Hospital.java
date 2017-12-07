package area;

import java.util.Set;

import project.Position;
import project.Rover;

public class Hospital extends Environment {

	public Hospital() {
		super();
	}
	
	public Hospital(Set<Position> p, Set<Area> a, Rover[] r) {
		super(p, a, r);
	}

}
