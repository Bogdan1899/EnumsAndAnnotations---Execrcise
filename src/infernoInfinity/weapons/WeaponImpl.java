package infernoInfinity.weapons;

import infernoInfinity.annotations.CustomAnnotation;
import infernoInfinity.enums.Gem;

@CustomAnnotation(
        author = "Pesho",
        revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"}
)
public abstract class WeaponImpl implements Weapon{

    private String name;
    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;
    private double itemLevel;

    protected WeaponImpl(String name,
                         int minDamage,
                         int maxDamage,
                         int numberOfSockets) {
        this.setName(name);
        this.setSockets(numberOfSockets);
        this.setMinDamage(minDamage);
        this.setMaxDamage(maxDamage);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMinDamage() {
        return minDamage;
    }

    private void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    @Override
    public int getMaxDamage() {
        return maxDamage;
    }

    private void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    private Gem[] getSockets() {
        return sockets;
    }

    private void setSockets(int numberOfSockets) {
        this.sockets = new Gem[numberOfSockets];
    }

    public double getItemLevel() {
        this.setItemLevel();
        return itemLevel;
    }

    private void setItemLevel() {
        int totalStrength = 0;
        int totalAgility = 0;
        int totalVitality = 0;

        for (Gem socket : sockets) {
            if (socket != null){
                totalStrength += socket.getStrength();
                totalAgility += socket.getAgility();
                totalVitality += socket.getVitality();
            }
        }

        this.itemLevel = (double) (this.getMaxDamage() + this.getMinDamage()) / 2 + totalStrength + totalAgility + totalVitality;
    }

    @Override
    public void addGem(int index, Gem gem) {
        if (index >= 0 && index < this.getSockets().length){
            Gem gemToRemove = this.getSockets()[index];
            this.getSockets()[index] = gem;

            this.setMinDamage(this.getMinDamage() + gem.getStrength() * 2 + gem.getAgility());
            this.setMaxDamage(this.getMaxDamage() + gem.getStrength() * 3 + gem.getAgility() * 4);

            if (gemToRemove != null){
                this.setMinDamage(this.getMinDamage() - (gemToRemove.getStrength() * 2 + gemToRemove.getAgility()));
                this.setMaxDamage(this.getMaxDamage() - (gemToRemove.getStrength() * 3 + gemToRemove.getAgility() * 4));
            }
        }
    }

    @Override
    public void removeGem(int index) {
        if (index >= 0 && index < this.getSockets().length){
            Gem gemToRemove = this.getSockets()[index];
            this.getSockets()[index] = null;
            this.setMinDamage(this.getMinDamage() - (gemToRemove.getStrength() * 2 + gemToRemove.getAgility()));
            this.setMaxDamage(this.getMaxDamage() - (gemToRemove.getStrength() * 3 + gemToRemove.getAgility() * 4));
        }
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.valueOf(this.getItemLevel()).compareTo(weapon.getItemLevel());
    }

    @Override
    public String toString() {
        int totalStrength = 0;
        int totalAgility = 0;
        int totalVitality = 0;

        for (Gem socket : sockets) {
            if (socket != null){
                totalStrength += socket.getStrength();
                totalAgility += socket.getAgility();
                totalVitality += socket.getVitality();
            }
        }

        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)",
                this.getName(), this.getMinDamage(), this.getMaxDamage(), totalStrength, totalAgility, totalVitality, this.getItemLevel());
    }
}
