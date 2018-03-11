package infernoInfinity.weapons;

import infernoInfinity.enums.Gem;

public interface Weapon extends Comparable<Weapon>{

    String getName();

    int getMinDamage();

    int getMaxDamage();

    double getItemLevel();

    void addGem(int index, Gem gem);

    void removeGem(int index);
}
