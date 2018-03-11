package infernoInfinity.database;

import infernoInfinity.weapons.Weapon;

import java.util.List;

public interface WeaponDatabase {

    List<Weapon> getWeapons();

    void addWeapon(Weapon weapon);

    Weapon getWeapon(String name);
}
