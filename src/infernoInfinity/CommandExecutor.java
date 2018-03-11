package infernoInfinity;

import infernoInfinity.annotations.CustomAnnotation;
import infernoInfinity.database.WeaponDatabase;
import infernoInfinity.enums.Gem;
import infernoInfinity.factories.WeaponFactory;
import infernoInfinity.io.Reader;
import infernoInfinity.weapons.Weapon;
import infernoInfinity.io.Writer;
import infernoInfinity.weapons.WeaponImpl;

import java.io.IOException;


public class CommandExecutor {

    private Reader reader;

    private Writer writer;

    private WeaponDatabase weaponDatabase;

    private WeaponFactory weaponFactory;

    public CommandExecutor(Reader reader, Writer writer, WeaponDatabase weaponDatabase, WeaponFactory weaponFactory) {
        this.reader = reader;
        this.writer = writer;
        this.weaponDatabase = weaponDatabase;
        this.weaponFactory = weaponFactory;
    }

    public void execute() throws IOException {
         String input = this.reader.inputReader();

         while (!input.equals("END")){
             String[] inputArgs = input.split(";");
             String command = inputArgs[0];
             String weaponName;
             Weapon weapon;
             int socketIndex;

             switch (command){
                 case "Create":
                     String weaponType = inputArgs[1];
                     weaponName = inputArgs[2];

                     weapon = this.weaponFactory.createWeapon(weaponType, weaponName);
                     this.weaponDatabase.addWeapon(weapon);

                     break;
                 case "Add":
                     weaponName = inputArgs[1];
                     socketIndex = Integer.parseInt(inputArgs[2]);
                     String gemType = inputArgs[3];

                     Gem gem = Gem.valueOf(gemType);
                     weapon = this.weaponDatabase.getWeapon(weaponName);
                     weapon.addGem(socketIndex, gem);

                     break;
                 case "Remove":
                     weaponName = inputArgs[1];
                     socketIndex = Integer.parseInt(inputArgs[2]);

                     weapon = this.weaponDatabase.getWeapon(weaponName);
                     weapon.removeGem(socketIndex);

                     break;
                 case "Print":
                     weaponName = inputArgs[1];

                     weapon = this.weaponDatabase.getWeapon(weaponName);
                     System.out.println(weapon.toString());

                     break;
                 case "Compare":
                     String firstWeaponName = inputArgs[1];
                     String secondWeaponName = inputArgs[2];

                     Weapon firstWeapon = this.weaponDatabase.getWeapon(firstWeaponName);
                     Weapon secondWeapon = this.weaponDatabase.getWeapon(secondWeaponName);

                     double result = firstWeapon.compareTo(secondWeapon);

                     if (result < 0){
                         System.out.println(secondWeapon.toString());
                     } else {
                         System.out.println(firstWeapon.toString());
                     }
                     break;
                 case "Author":
                     CustomAnnotation author = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                     System.out.println("Author: " + author.author());
                     break;
                 case "Revision":
                     CustomAnnotation revision = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                     System.out.println("Revision: " + revision.revision());
                     break;
                 case "Description":
                     CustomAnnotation description = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                     System.out.println("Class description: " + description.description());
                     break;
                 case "Reviewers":
                     CustomAnnotation reviewers = WeaponImpl.class.getAnnotation(CustomAnnotation.class);
                     System.out.println("Reviewers: " + String.join(", ", reviewers.reviewers()));
                     break;
             }

             input = this.reader.inputReader();
         }
    }
}
