package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class User implements RoverObserver{
	
	private Set<Rover> rovers;
	private Mission[] currentMissions;
	private GUI gui;
	private Map<String, Position> positions;
	
	public User(Set<Rover> rovers, Mission[] missions) {
		this.rovers = rovers;
		this.currentMissions = missions;
		positions = new HashMap<String, Position>();
		for(Rover r : this.rovers) {
			r.observe(this);
		}
		
		System.out.println("Starting procedure...");
		Procedure p = new Procedure(rovers, new HospitalProcedure());
		p.start();
		
		gui = new Console(this);
	}

	@Override
	public void updateRoverPosition(Position newPosition, String name) {
		positions.put(name, newPosition);
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
	
	public Map<String, Position> getRoverPositions(){
		return positions;
	}
}
