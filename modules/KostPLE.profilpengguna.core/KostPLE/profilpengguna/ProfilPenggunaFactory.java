package KostPLE.profilpengguna;

import KostPLE.profilpengguna.core.ProfilPengguna;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;
import java.util.Arrays;


public class ProfilPenggunaFactory{
    private static final Logger LOGGER = Logger.getLogger(ProfilPenggunaFactory.class.getName());

    public ProfilPenggunaFactory()
    {

    }

    public static ProfilPengguna createProfilPengguna(String fullyQualifiedName, Object ... base)
    {
        ProfilPengguna record = null;
//        Constructor<?> constructor = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            
            
            Constructor<?>[] constructorList = clz.getDeclaredConstructors();
            Constructor<?> constructor = null;

//            Class<?>[] paramTypes = constructor.getParameterTypes();

            for (int i = 0; i < constructorList.length; i++) {
            	try {
            		constructor = constructorList[i];
            		record = (ProfilPengguna) constructor.newInstance(base);
            		i = constructorList.length;
            	} catch (IllegalArgumentException e) {
            		if (i < constructorList.length - 1) {
            			System.out.println("Trying other constructor");
            			continue;
            		} else {
            			throw e;
            		}
            	}
            }
//            for (int i = 0; i < base.length; i++) {
//                LOGGER.info("Parameter " + i + ": " + (base[i] == null ? "null" : base[i].getClass().getName()));
//            }
//            
//            System.out.println(paramTypes.length);
//            for (int i = 0; i < paramTypes.length; i++) {
//                System.out.println("  Parameter " + i + ": " + paramTypes[i].getName());
//            }
//            
            
//            record = (ProfilPengguna) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of ProfilPengguna.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            LOGGER.severe("Check your constructor argument types or count.");
            LOGGER.severe("Failed to instantiate or access constructor: " + e.getMessage());
            e.printStackTrace();
            System.exit(30);
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
