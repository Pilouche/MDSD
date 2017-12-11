package project;

public class PathAndLength {
	private Position[] positions;
	private double lengthOfPath;
	
	public PathAndLength(Position[] p, double lengthOfPath) {
		this.positions = p;
		this.lengthOfPath = lengthOfPath;
	}
	
	public double getLength() {
		return lengthOfPath;
	}
	
	public Position[] getPositions() {
		return positions;
	}
}
