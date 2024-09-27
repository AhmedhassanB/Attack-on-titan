package game.engine.weapons.factory;

import java.io.IOException;
import java.util.HashMap;

import game.engine.dataloader.DataLoader;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.weapons.Weapon;
import game.engine.weapons.WeaponRegistry;

public class WeaponFactory {

	private final HashMap<Integer, WeaponRegistry> weaponShop;

	public WeaponFactory() throws IOException {
		weaponShop = DataLoader.readWeaponRegistry();
	}

	public HashMap<Integer, WeaponRegistry> getWeaponShop() {
		return weaponShop;
	}

	public FactoryResponse buyWeapon(int resources, int weaponCode) throws InsufficientResourcesException{
     WeaponRegistry weaponRegistry=weaponShop.get(weaponCode);
      if(weaponRegistry.getPrice()>resources){
		  throw new InsufficientResourcesException(resources);
	  }
	Weapon weapon= weaponRegistry.buildWeapon();
	  int remainres=resources-weaponRegistry.getPrice();
	    return new FactoryResponse(weapon,remainres);

   }
   public void addWeaponToShop(int code, int price){
	   WeaponRegistry weapon = new WeaponRegistry(code, price);
	   weaponShop.put(code, weapon);
   }
   public void addWeaponToShop(int code, int price, int damage, String name) {
	   WeaponRegistry weapon = new WeaponRegistry(code, price, damage, name);
	   weaponShop.put(code, weapon);
   }

   public void addWeaponToShop(int code, int price, int damage, String name, int minRange, int
		maxRange) {
	   WeaponRegistry weapon = new WeaponRegistry(code, price, damage, name, minRange, maxRange);
	   weaponShop.put(code, weapon);
   }


}
