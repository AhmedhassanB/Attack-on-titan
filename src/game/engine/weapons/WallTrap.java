package game.engine.weapons;

import java.util.PriorityQueue;

import game.engine.interfaces.Attacker;
import game.engine.titans.Titan;

public class WallTrap extends Weapon implements Attacker {
    public final static int WEAPON_CODE = 4;

    public WallTrap(int baseDamage) {
        super(baseDamage);
    }

    @Override
   public int turnAttack(PriorityQueue<Titan> laneTitans) {

        if (laneTitans.isEmpty()) {
            return 0; // No titans in the lane, return 0
        }

        // Get the closest titan from the priority queue
        Titan closestTitan = laneTitans.peek();

        // Check if the closest titan has reached the base/wall (distance == 0)
        if (closestTitan.getDistance() == 0) {
            // Attack the titan with base damage
            int resourcesGained = closestTitan.takeDamage(getDamage());

            // If the titan was defeated, it should be removed from the queue
            if (closestTitan.isDefeated()) {
                // Remove the defeated titan from the lane
                laneTitans.remove(closestTitan);
            }

            return resourcesGained; // Return the resources gained from defeating the titan
        }

        // If no titans were attacked (e.g., none at the base/wall), return 0
        return 0;


    }
}

