package infernoInfinity.weapons;

public class Sword extends WeaponImpl{

    private static final int MIN_DAMAGE = 4;

    private static final int MAX_DAMAGE = 6;

    private static final int SOCKET_NUMBER = 3;

    public Sword(String name) {
        super(name, MIN_DAMAGE, MAX_DAMAGE, SOCKET_NUMBER);
    }
}
