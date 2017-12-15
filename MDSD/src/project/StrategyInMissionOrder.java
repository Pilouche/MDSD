package project;

import area.Environment;
import area.EnvironmentAdapter;
import project.Mission;
import project.Point;

/**
 * 
 * @param mission
 * @param environment
 * @return
 * @param type
 */
public class StrategyInMissionOrder extends AbstractStrategy {

	public StrategyInMissionOrder() {
		super();
	}

	@Override
	public void calculateWholePath(Environment environment, Position currentPosition, Rover r) {
		super.setExtraPositions(super.getAllUnvisitedPoints());
	}


};