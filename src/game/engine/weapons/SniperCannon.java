package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.interfaces.Attacker;
import game.engine.titans.Titan;

public class SniperCannon extends Weapon implements Attacker {
	public final static int WEAPON_CODE = 2;

	public SniperCannon(int baseDamage) {
		super(baseDamage);
	}

	@Override
	public int turnAttack(PriorityQueue<Titan> laneTitans) {
		int resourcesGained = 0;
		if (!laneTitans.isEmpty()) {
			Titan x = laneTitans.peek();
			resourcesGained += x.takeDamage(getDamage());

			if (x.isDefeated()) {
				laneTitans.remove();
			}


		}
        return resourcesGained;
    }
}

