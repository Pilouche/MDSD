package area;

import java.util.Set;

import project.Boundary;

public abstract class AbstractRoom extends PhysicalArea {
	AbstractDivision division;

	public AbstractRoom(Set<Boundary> boundaries) {
		super(boundaries);
	}
	
	public AbstractRoom(Set<Boundary> boundaries, AbstractDivision division) {
		super(boundaries);
		this.division = division;
	}

}
