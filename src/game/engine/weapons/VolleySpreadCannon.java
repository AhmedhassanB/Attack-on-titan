package game.engine.weapons;

import java.util.ArrayList;
import java.util.PriorityQueue;

import game.engine.interfaces.Attacker;
import game.engine.titans.Titan;

public class VolleySpreadCannon extends Weapon implements Attacker {
	public final static int WEAPON_CODE = 3;
	private final int minRange;
	private final int maxRange;

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public VolleySpreadCannon(int baseDamage, int minRange, int maxRange) {
		super(baseDamage);
		this.maxRange = maxRange;
		this.minRange = minRange;
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
	    int resourcesGained=0;
		ArrayList<Titan> titans = new ArrayList<>();
		while (!(laneTitans.isEmpty())) {
			Titan titan = laneTitans.poll();
			if (titan.getDistance() >= minRange && titan.getDistance() <= maxRange) {
				int result = titan.takeDamage(getDamage());
				if (result > 0) {
					resourcesGained += result;
				}
			}
			if (!titan.isDefeated()) {
				titans.add(titan);
			}
		}
				for (Titan Titan  : titans){
					laneTitans.add(Titan);
	        }
		 return resourcesGained;

       }
}
