package infernoInfinity.database;

import infernoInfinity.weapons.Weapon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WeaponDatabaseImpl implements WeaponDatabase{

    private List<Weapon> weapons;

    public WeaponDatabaseImpl() {
        this.setWeapons(new LinkedList<>());
    }

    public List<Weapon> getWeapons() {
        return Collections.unmodifiableList(this.weapons);
    }

    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }

    @Override
    public Weapon getWeapon(String name) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().equals(name)){
                return weapon;
            }
        }

        throw new NullPointerException();
    }

    private void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }
}
