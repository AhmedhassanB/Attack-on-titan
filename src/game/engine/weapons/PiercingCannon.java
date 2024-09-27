package game.engine.weapons;
import java.util.Comparator;
import java.util.PriorityQueue;

import game.engine.interfaces.Attacker;
import game.engine.titans.Titan;

public class PiercingCannon extends Weapon implements Attacker {
	public final static int WEAPON_CODE = 1;

	public PiercingCannon(int baseDamage) {
		super(baseDamage);
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		 int resourcesGained = 0;
		   int titansAttacked = 0;
		PriorityQueue<Titan> titans = new PriorityQueue<>(Comparator.comparing(Titan::getDistance));
		   
            while (titansAttacked<5 && !laneTitans.isEmpty()) {
				 Titan titan=laneTitans.poll(); // take the titan and poll it to make attake on it
					if (titan != null) {
						int resource = titan.takeDamage(getDamage());


							resourcesGained += resource;


					}

					if (!titan.isDefeated()){
						titans.add(titan);
					}titansAttacked++;
			}
			laneTitans.addAll(titans);
            return resourcesGained;
    }


}
