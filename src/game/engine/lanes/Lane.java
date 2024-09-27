package game.engine.lanes;

import java.util.*;

import game.engine.base.Wall;
import game.engine.titans.Titan;
import game.engine.weapons.Weapon;

public class Lane implements Comparable<Lane> {

	private final PriorityQueue<Titan> titans;
	private final ArrayList<Weapon> weapons;
	private final Wall laneWall;
	private int dangerLevel;

	public Lane(Wall laneWall) {
		this.laneWall = laneWall;
		titans = new PriorityQueue<Titan>();
		weapons = new ArrayList<Weapon>();
		dangerLevel = 0;
	}

	public int getDangerLevel() {
		return dangerLevel;
	}

	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	public Wall getLaneWall() {
		return laneWall;
	}

	public PriorityQueue<Titan> getTitans() {
		return titans;
	}

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	@Override
	public int compareTo(Lane L) {

		return this.dangerLevel - L.dangerLevel;
	}
	
	public void addTitan(Titan titan) {
		titans.add(titan);
	}
	public void addWeapon(Weapon weapon) {
		 weapons.add(weapon);
	}

	public void moveLaneTitans() {
		PriorityQueue<Titan> s = new PriorityQueue<>();
		while(!titans.isEmpty()) {
			Titan titan1 = titans.poll();
			s.add(titan1);
			if(!titan1.hasReachedTarget())
				titan1.move();
		}
		titans.addAll(s);
	}
	public int performLaneTitansAttacks() {
		int totalResourcesGained = 0;
		for (Titan titan : titans) {
			// Check if the titan has reached the base or wall
			if (titan.hasReachedTarget()) {
				totalResourcesGained += titan.attack(laneWall);
			}
		}
		return totalResourcesGained;
	}

		public int performLaneWeaponsAttacks() {
			int totalResourcesGathered = 0;
			for (Weapon weapon : weapons) {

				totalResourcesGathered += weapon.turnAttack(titans);

			}
			return totalResourcesGathered;
		}


		public boolean isLaneLost() {
			if(laneWall.getCurrentHealth()<=0){
				return true;
			}
			else return false;
		}




	public void updateLaneDangerLevel(){
		int danger =0;
		if(!isLaneLost()){
			for(Titan titan : titans){
				danger+=titan.getDangerLevel();
			}
		}
		dangerLevel = danger;
	}


	}
	

	
	
	

	
	


