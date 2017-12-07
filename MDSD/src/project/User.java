package project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class User implements RoverObserver{
	
	private Set<Rover> rovers;
	private Mission[] currentMissions;
	private GUI gui;
	
	public User(Set<Rover> rovers, Mission[] missions) {
		this.rovers = rovers;
		this.currentMissions = missions;
		gui = new Console(this);
		for(Rover r : rovers) {
			r.observe(this);
		}
	}

	@Override
	public void updateRoverPosition(Position newPosition) {
		// TODO Auto-generated method stub
		
	}
	
	public void addMission(Mission addedMission) {
		Mission[] tempMissionsArray = new Mission[currentMissions.length + 1];
		for(int x = 0; x < currentMissions.length; x++) {
			tempMissionsArray[x] = currentMissions[x];
		}
		tempMissionsArray[currentMissions.length] = addedMission;
		currentMissions = tempMissionsArray;
	}
	public Set<Mission> getMissions(){
		return new HashSet<Mission>(Arrays.asList(currentMissions));
	}
	
	public void setRovers(Set<Rover> rovers) {
		this.rovers = rovers;
	}
}
