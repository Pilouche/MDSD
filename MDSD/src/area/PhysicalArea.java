package area;

import java.util.Set;

import project.Boundary;

public class PhysicalArea extends Area {

	public PhysicalArea(Set<Boundary> boundaries) {
		//TODO Check so that no area already exists in within these boundries? 
		super(boundaries);
	}

}