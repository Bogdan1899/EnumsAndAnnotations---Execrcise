package infernoInfinity.weapons;

public class Knife extends WeaponImpl{

    private static final int MIN_DAMAGE = 3;

    private static final int MAX_DAMAGE = 4;

    private static final int SOCKET_NUMBER = 2;

    public Knife(String name) {
        super(name, MIN_DAMAGE, MAX_DAMAGE, SOCKET_NUMBER);
    }
}
