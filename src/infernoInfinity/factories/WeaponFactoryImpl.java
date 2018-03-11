package infernoInfinity.factories;

import infernoInfinity.weapons.Weapon;
import infernoInfinity.weapons.Axe;
import infernoInfinity.weapons.Knife;
import infernoInfinity.weapons.Sword;

public class WeaponFactoryImpl implements WeaponFactory{

    @Override
    public Weapon createWeapon(String type, String name) {

        switch (type){
            case "AXE":
                return new Axe(name);
            case "SWORD":
                return new Sword(name);
            case "KNIFE":
                return new Knife(name);
            default:
                    throw new IllegalArgumentException("No such weapon!");
        }
    }
}
