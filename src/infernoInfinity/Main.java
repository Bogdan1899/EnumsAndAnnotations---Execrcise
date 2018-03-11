package infernoInfinity;

import infernoInfinity.database.WeaponDatabase;
import infernoInfinity.database.WeaponDatabaseImpl;
import infernoInfinity.factories.WeaponFactory;
import infernoInfinity.factories.WeaponFactoryImpl;
import infernoInfinity.io.ConsoleReader;
import infernoInfinity.io.ConsoleWriter;
import infernoInfinity.io.Reader;
import infernoInfinity.io.Writer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        WeaponFactory weaponFactory = new WeaponFactoryImpl();
        WeaponDatabase weaponDatabase = new WeaponDatabaseImpl();
        CommandExecutor commandExecutor = new CommandExecutor(reader, writer, weaponDatabase, weaponFactory);
        commandExecutor.execute();
    }
}
