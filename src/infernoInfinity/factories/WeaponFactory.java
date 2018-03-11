package infernoInfinity.factories;

import infernoInfinity.weapons.Weapon;

public interface WeaponFactory {

    Weapon createWeapon(String type, String name);
}
