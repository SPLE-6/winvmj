package KostPLE.profilpengguna;

import KostPLE.profilpengguna.core.ProfilPenggunaResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class ProfilPenggunaResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(ProfilPenggunaFactory.class.getName());

    public ProfilPenggunaResourceFactory()
    {

    }

    public static ProfilPenggunaResource createProfilPenggunaResource(String fullyQualifiedName, Object ... base)
    {
        ProfilPenggunaResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (ProfilPenggunaResource) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of ProfilPengguna.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of ProfilPengguna.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of ProfilPengguna.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of ProfilPengguna.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
