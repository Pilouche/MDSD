package project;

import area.Environment;

public abstract class AbstractCollisionStrategy {
	public AbstractCollisionStrategy() {

	}

	public abstract PathAndLength calculatePathBetweenPoints(Environment environment, Position one, Position two);
}
