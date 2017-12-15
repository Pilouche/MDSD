package area;

import java.awt.Color;
import java.util.Set;

import project.Mission;
import project.Position;
import project.Rover;

public interface Environment {
	public void setPositions(Set<Position> positions);

	public Set<Position> getPositions();
	public Set<Area> getAreas();
	public void addArea(Area a);
	public Set<Rover> getRovers();
	public Mission[] getMissions();
	
}
