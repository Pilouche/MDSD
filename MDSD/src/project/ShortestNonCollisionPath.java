package project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import area.Environment;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;

public class ShortestNonCollisionPath extends AbstractCollisionStrategy {
	private static Map<String, PathAndLength> alreadyCalculatedPaths;
	
	
	@Override
	public PathAndLength calculatePathBetweenPoints(Environment environment, Position one, Position two) {
		// TODO Auto-generated method stub
		if(alreadyCalculatedPaths.containsKey(one.toString() + "<>" + two.toString())) {
			return alreadyCalculatedPaths.get(one.toString() + "<>" + two.toString());
		} else if(alreadyCalculatedPaths.containsKey(two.toString() + "<>" + one.toString())) {
			return alreadyCalculatedPaths.get(two.toString() + "<>" + one.toString());
		} else {
			for(Boundary b : environment.getBoundries()) {
				double changeX = one.getX()-two.getX();
				double changeZ = one.getZ()-two.getZ();
				double xDivZ = changeX/changeZ;
				double zValue;
				double xValue;
				double oneBigTwo;
				double cutOnRise;
				if(b.getP1x() == b.getP2x()) {
					zValue = (one.getX() - b.getP1x())*xDivZ;
					if(b.getP1x() < b.getP2x()) oneBigTwo = -0.5; else oneBigTwo = 0.5;
					if(zValue > one.getZ()) cutOnRise = -0.5; else cutOnRise = 0.5;
					if((zValue <= b.getP1z() && zValue >= b.getP1z()) || (zValue >= b.getP1z() && zValue <= b.getP1z())) {
						if(calculatePathBetweenPoints(environment,new Position(b.getP1x() + oneBigTwo, b.getP1z() + cutOnRise), two).getLength() < calculatePathBetweenPoints(environment,new Position(b.getP2x() - oneBigTwo, b.getP2z() + cutOnRise), two).getLength()) {
							Set<Position> p = new HashSet<Position>();
							Position tempPos = new Position(b.getP1x() + oneBigTwo, b.getP1z() - cutOnRise);
							p.add(tempPos);
							PathAndLength temp = calculatePathBetweenPoints(environment, new Position(b.getP1x() + oneBigTwo, b.getP1z() + cutOnRise), two);
							p.addAll(new HashSet<Position>(Arrays.asList(temp.getPositions())));
							Position[] tempPositions = p.toArray(new Position[p.size()]);
							return new PathAndLength(tempPositions, temp.getLength() + one.getDistance(tempPos));
						} else {
							//Take the number of walls and boundries combained*two as the maximum depth.
						}
					}
				} else {
					
				}
			}
			for(AbstractWall w : environment.getWalls()) {
				if(w.getP1x() == w.getP2x()) {
					
				} else {
					
				}
			}
		}
		return null;
	}
	

}
