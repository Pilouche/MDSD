package area;

import java.util.Set;

import simbad.sim.Boundary;
import project.Position;

public class PhysicalArea extends Area {

	public PhysicalArea(Set<Position> positions) {
		//TODO Check so that no area already exists in within these boundries? 
		super(positions);
	}

}
