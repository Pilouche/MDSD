package area;

import java.util.Set;

import project.Position;

public abstract class AbstractRoom extends PhysicalArea {
	AbstractDivision division;

	public AbstractRoom(Set<Position> positions) {
		super(positions);
	}
	
	public AbstractRoom(Set<Position> positions, AbstractDivision division) {
		super(positions);
		this.division = division;
	}

}
