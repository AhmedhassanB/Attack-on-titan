package game.engine.titans;

import game.engine.interfaces.Mobil;

public class ColossalTitan extends Titan implements Mobil {
	public final static int TITAN_CODE = 4;

	public ColossalTitan(int baseHealth, int baseDamage, int heightInMeters, int distanceFromBase, int speed,
			int resourcesValue, int dangerLevel) {
		super(baseHealth, baseDamage, heightInMeters, distanceFromBase, speed, resourcesValue, dangerLevel);
	}
	
	public boolean move() {
	    
	    boolean targetReached = super.move();
	       setSpeed(getSpeed() + 1);
	           return targetReached;
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
