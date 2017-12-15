package project;

import area.EnvironmentAdapter;

public abstract class AbstractCollisionStrategy {
	public AbstractCollisionStrategy() {

	}

	public abstract PathAndLength calculatePathBetweenPoints(EnvironmentAdapter environment, Position one, Position two);
}
