package infernoInfinity.weapons;

public class Axe extends WeaponImpl{

    private static final int MIN_DAMAGE = 5;

    private static final int MAX_DAMAGE = 10;

    private static final int SOCKET_NUMBER = 4;

    public Axe(String name) {
        super(name, MIN_DAMAGE, MAX_DAMAGE, SOCKET_NUMBER);
    }
}
