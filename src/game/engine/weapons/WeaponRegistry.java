package game.engine.weapons;


public class WeaponRegistry {

	private final int code;
	private String name;
	private int price;
	private int damage;
	private int minRange;
	private int maxRange;

	public int getCode() {
		return code;
	}

	public int getPrice() {
		return price;
	}

	public int getDamage() {
		return damage;
	}

	public String getName() {
		return name;
	}

	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	public WeaponRegistry(int code, int price) {
		this.code = code;
		this.price = price;

	}

	public WeaponRegistry(int code, int price, int damage, String name) {
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.name = name;

	}

	public WeaponRegistry(int code, int price, int damage, String name, int minRange, int maxRange) {
		this.code = code;
		this.price = price;
		this.damage = damage;
		this.name = name;
		this.minRange = minRange;
		this.maxRange = maxRange;
	}
	public Weapon buildWeapon() {
        switch (code) {
            case 1: // Assuming 1 represents Piercing Cannon
                return new PiercingCannon(damage);
            case 2: // Assuming 2 represents Sniper Cannon
                return new SniperCannon(damage);
            case 3: // Assuming 3 represents Volley Cannon
                return new VolleySpreadCannon(damage,minRange,maxRange);
            case 4: // Assuming 4 represents Wall Trap
                return new WallTrap(damage);
            default:
                return null;
        }
    }

}
