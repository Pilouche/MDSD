// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package area;

import java.util.Set;
import java.awt.Polygon;
import project.Position;

public abstract class Area extends Polygon{
	
	public Area(Set<Position> corners) {
		super();
		for(Position p : corners) {
			this.addPoint((int)(p.getX()), (int)(p.getZ()));
		}	
	}

	public boolean contains(Position p) {
		return this.contains(p.getX(),p.getZ());
	}
};
