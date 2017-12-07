package project;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Console implements GUI {
	private Scanner sc;
	private User user;
	
	public Console(User user) {
		this.user = user;
		startGUI();
	}

	public void startGUI() {
		System.out.println("Running main2");
		boolean menu = true;
		while(menu) {
			System.out.println("Menu");
			System.out.println("1. Change mission");
			System.out.println("2. Start mission");
			System.out.println("3. Stop mission");
			System.out.println("4. List positions");
			System.out.println("5. Exit");
			sc = new Scanner(System.in);
			int choice = sc.nextInt();
			Mission m;
			switch(choice) {
				case 1:
					m = chooseMission(false);
					System.out.println("Menu");
					System.out.println("1. Add point");
					System.out.println("2. Remove point");
					int choiceMission = sc.nextInt();
					switch(choiceMission) {
						case 1: addPositionMission(m);
								break;
						case 2: removePositionMission(m);
								break;
						default:
								System.out.println("Invalid choice");
								break;
					}
					break;
				case 2:
					m = chooseMission(false);
					m.startMission();
					break;
				case 3:
					m = chooseMission(true);
					m.stopMission();
					break;
				case 4:
					listMissions();
					break;
				case 5:
					menu = false;
					break;
					
				default:
					System.out.println("Invalid choice");
					break;
			}		
		}
		return;
	}
	
	public void listMissions() {
		Map<String,Position> map = user.getRoverPositions();
		for(String s : map.keySet()) {
			System.out.println(s + " " + map.get(s).toString() );
		}
	}
	
	public Mission chooseMission(boolean started) {
		Mission chosenMission = null;
		while(chosenMission == null) {
			System.out.println("Choose mission to change:");
			Set<Mission> setMissions = user.getMissions(); //fetch set of missions from user that are started or not? user.getMission(started)
			Mission[] missions = setMissions.toArray(new Mission[setMissions.size()]);
			
			for(int i=0;i<missions.length;i++) {
				System.out.println(i+". Mission "+i);
			}
			int choice = sc.nextInt();
			if(choice>=0 && choice < missions.length) {
				chosenMission = missions[choice];
			}else {
				System.out.println("Wrong choice");
			}
		}
		
		return chosenMission;
		
	}
	
	public void addPositionMission(Mission m) {
		System.out.println("x coordinate : ");
		float x = sc.nextFloat();
		System.out.println("z coordinate : ");
		float z = sc.nextFloat();
		Position pos = new Position(x,z);
		m.addPosition(pos); // to implement
		
	}
	
	public void removePositionMission(Mission m) {
		Position[] positions = m.getUnvisitedPoints();
		for (int i =0; i< positions.length;i++) {
			System.out.println(i+". Position "+i+" : ("+ positions[i].getX()+","+positions[i].getZ()+")");
		}
		int choice = sc.nextInt();
		m.removePosition(choice); // to implement
	}

	
	

}
