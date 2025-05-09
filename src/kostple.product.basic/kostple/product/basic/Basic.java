package kostple.product.basic;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vmj.routing.route.VMJCors;
import vmj.routing.route.VMJServer;
import vmj.routing.route.Router;
import vmj.hibernate.integrator.HibernateUtil;
import org.hibernate.cfg.Configuration;

import vmj.auth.model.UserResourceFactory;
import vmj.auth.model.RoleResourceFactory;
import vmj.auth.model.core.UserResource;
import vmj.auth.model.core.RoleResource;

import KostPLE.profilpengguna.ProfilPenggunaResourceFactory;
import KostPLE.profilpengguna.core.ProfilPenggunaResource;
import KostPLE.profilpengguna.ProfilPenggunaServiceFactory;
import KostPLE.profilpengguna.core.ProfilPenggunaService;
import KostPLE.properti.PropertiResourceFactory;
import KostPLE.properti.core.PropertiResource;
import KostPLE.properti.PropertiServiceFactory;
import KostPLE.properti.core.PropertiService;
import KostPLE.kamar.KamarResourceFactory;
import KostPLE.kamar.core.KamarResource;
import KostPLE.kamar.KamarServiceFactory;
import KostPLE.kamar.core.KamarService;
import KostPLE.pemesanan.PemesananResourceFactory;
import KostPLE.pemesanan.core.PemesananResource;
import KostPLE.pemesanan.PemesananServiceFactory;
import KostPLE.pemesanan.core.PemesananService;

public class Basic {

	public static void main(String[] args) {

		// get hostAddress and portnum from env var
        // ex:
        // AMANAH_HOST_BE --> "localhost"
        // AMANAH_PORT_BE --> 7776
		String hostAddress= getEnvVariableHostAddress("AMANAH_HOST_BE");
        int portNum = getEnvVariablePortNumber("AMANAH_PORT_BE");
        activateServer(hostAddress, portNum);
		setCors();

		Configuration configuration = new Configuration();
		// panggil setter setelah membuat object dari kelas Configuration
        // ex:
        // AMANAH_DB_URL --> jdbc:postgresql://localhost:5432/superorg
        // AMANAH_DB_USERNAME --> postgres
        // AMANAH_DB_PASSWORD --> postgres123
		setDBProperties("AMANAH_DB_URL", "url", configuration);
        setDBProperties("AMANAH_DB_USERNAME", "username", configuration);
        setDBProperties("AMANAH_DB_PASSWORD","password", configuration);

		configuration.addAnnotatedClass(vmj.auth.model.core.Role.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.RoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRole.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserRoleImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.User.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserComponent.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserDecorator.class);
        configuration.addAnnotatedClass(vmj.auth.model.core.UserImpl.class);
        configuration.addAnnotatedClass(vmj.auth.model.passworded.UserImpl.class);

		configuration.addAnnotatedClass(KostPLE.profilpengguna.core.ProfilPengguna.class);
		configuration.addAnnotatedClass(KostPLE.profilpengguna.core.ProfilPenggunaComponent.class);
		configuration.addAnnotatedClass(KostPLE.profilpengguna.core.ProfilPenggunaDecorator.class);
		configuration.addAnnotatedClass(KostPLE.profilpengguna.core.ProfilPenggunaImpl.class);
		configuration.addAnnotatedClass(KostPLE.properti.core.Properti.class);
		configuration.addAnnotatedClass(KostPLE.properti.core.PropertiComponent.class);
		configuration.addAnnotatedClass(KostPLE.properti.core.PropertiDecorator.class);
		configuration.addAnnotatedClass(KostPLE.properti.core.PropertiImpl.class);
		configuration.addAnnotatedClass(KostPLE.kamar.core.Kamar.class);
		configuration.addAnnotatedClass(KostPLE.kamar.core.KamarComponent.class);
		configuration.addAnnotatedClass(KostPLE.kamar.core.KamarDecorator.class);
		configuration.addAnnotatedClass(KostPLE.kamar.core.KamarImpl.class);
		configuration.addAnnotatedClass(KostPLE.pemesanan.core.Pemesanan.class);
		configuration.addAnnotatedClass(KostPLE.pemesanan.core.PemesananComponent.class);
		configuration.addAnnotatedClass(KostPLE.pemesanan.core.PemesananDecorator.class);
		configuration.addAnnotatedClass(KostPLE.pemesanan.core.PemesananImpl.class);

		Map<String, Object> featureModelMappings = mappingFeatureModel();
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Map<String, String[]>>>(){}.getType();
        String convertedFeatureModelMappings = gson.toJson(featureModelMappings, type);
		
        configuration.setProperty("feature.model.mappings", convertedFeatureModelMappings);
		configuration.buildMappings();
		HibernateUtil.buildSessionFactory(configuration);

		createObjectsAndBindEndPoints();
	}

	public static void activateServer(String hostName, int portNumber) {
		VMJServer vmjServer = VMJServer.getInstance(hostName, portNumber);
		try {
			vmjServer.startServerGeneric();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createObjectsAndBindEndPoints() {
		System.out.println("== CREATING OBJECTS AND BINDING ENDPOINTS ==");
		UserResource userResource = UserResourceFactory
            .createUserResource("vmj.auth.model.core.UserResourceImpl"
			);

		RoleResource roleResource = RoleResourceFactory
        	.createRoleResource("vmj.auth.model.core.RoleResourceImpl"
			);
        
        UserResource userPasswordedResource = UserResourceFactory
	        .createUserResource("vmj.auth.model.passworded.UserResourceImpl"
			,
		    UserResourceFactory.createUserResource("vmj.auth.model.core.UserResourceImpl"));

        ProfilPenggunaService profilpenggunaProfilPengguna2Service = ProfilPenggunaServiceFactory
            .createProfilPenggunaService("KostPLE.profilpengguna.core.ProfilPenggunaServiceImpl"
            	);		

        ProfilPenggunaResource profilpenggunaProfilPengguna2Resource = ProfilPenggunaResourceFactory
            .createProfilPenggunaResource("KostPLE.profilpengguna.core.ProfilPenggunaResourceImpl"
                );
			
        PropertiService propertiProperti2Service = PropertiServiceFactory
            .createPropertiService("KostPLE.properti.core.PropertiServiceImpl"
            	);		

        PropertiResource propertiProperti2Resource = PropertiResourceFactory
            .createPropertiResource("KostPLE.properti.core.PropertiResourceImpl"
                );
			
        KamarService kamarKamar2Service = KamarServiceFactory
            .createKamarService("KostPLE.kamar.core.KamarServiceImpl"
            	);		

        KamarResource kamarKamar2Resource = KamarResourceFactory
            .createKamarResource("KostPLE.kamar.core.KamarResourceImpl"
                );
			
        PemesananService pemesananPemesanan2Service = PemesananServiceFactory
            .createPemesananService("KostPLE.pemesanan.core.PemesananServiceImpl"
            	);		

        PemesananResource pemesananPemesanan2Resource = PemesananResourceFactory
            .createPemesananResource("KostPLE.pemesanan.core.PemesananResourceImpl"
                );
			
        PropertiService propertiProperti4Service = PropertiServiceFactory
            .createPropertiService("KostPLE.properti.core.PropertiServiceImpl"
            	);		

        PropertiResource propertiProperti4Resource = PropertiResourceFactory
            .createPropertiResource("KostPLE.properti.core.PropertiResourceImpl"
                );
			

		System.out.println("propertiProperti4Resource endpoints binding");
		Router.route(propertiProperti4Resource);
		
		System.out.println("propertiProperti4Service endpoints binding");
		Router.route(propertiProperti4Service);
		
		System.out.println("pemesananPemesanan2Resource endpoints binding");
		Router.route(pemesananPemesanan2Resource);
		
		System.out.println("pemesananPemesanan2Service endpoints binding");
		Router.route(pemesananPemesanan2Service);
		
		System.out.println("kamarKamar2Resource endpoints binding");
		Router.route(kamarKamar2Resource);
		
		System.out.println("kamarKamar2Service endpoints binding");
		Router.route(kamarKamar2Service);
		
		System.out.println("propertiProperti2Resource endpoints binding");
		Router.route(propertiProperti2Resource);
		
		System.out.println("propertiProperti2Service endpoints binding");
		Router.route(propertiProperti2Service);
		
		System.out.println("profilpenggunaProfilPengguna2Resource endpoints binding");
		Router.route(profilpenggunaProfilPengguna2Resource);
		
		System.out.println("profilpenggunaProfilPengguna2Service endpoints binding");
		Router.route(profilpenggunaProfilPengguna2Service);
		
		System.out.println("authResource endpoints binding");
		Router.route(userPasswordedResource);
		Router.route(roleResource);
		Router.route(userResource);
	}

	private static Map<String, Object> mappingFeatureModel() {
		Map<String, Object> featureModelMappings = new HashMap<>();

		featureModelMappings.put(
            KostPLE.profilpengguna.core.ProfilPenggunaComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					KostPLE.profilpengguna.core.ProfilPenggunaComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            KostPLE.properti.core.PropertiComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					KostPLE.properti.core.PropertiComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            KostPLE.kamar.core.KamarComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					KostPLE.kamar.core.KamarComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
            KostPLE.pemesanan.core.PemesananComponent.class.getName(),
			new HashMap<String, String[]>() {{
				put("components", new String[] {
					KostPLE.pemesanan.core.PemesananComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}}
        );

		featureModelMappings.put(
	            vmj.auth.model.core.UserComponent.class.getName(),
				new HashMap<String, String[]>() {{
					put("components", new String[] {
						vmj.auth.model.core.UserComponent.class.getName()
					});
					put("deltas", new String[] {
						vmj.auth.model.passworded.UserImpl.class.getName()
					});
				}}
	        );
	        
	    featureModelMappings.put(
				vmj.auth.model.core.RoleComponent.class.getName(),
				new HashMap<String, String[]>() {{
					put("components", new String[] {
						vmj.auth.model.core.RoleComponent.class.getName()
					});
					put("deltas", new String[] {
					});
				}}
	        );
	    
	    featureModelMappings.put(
				vmj.auth.model.core.UserRoleComponent.class.getName(),
				new HashMap<String, String[]>() {{
					put("components", new String[] {
						vmj.auth.model.core.UserRoleComponent.class.getName()
					});
					put("deltas", new String[] {
					});
				}}
	        );
	    
		return featureModelMappings;
	}

	public static void setDBProperties(String varname, String typeProp, Configuration configuration) {
		String varNameValue = System.getenv(varname);
		String propertyName = String.format("hibernate.connection.%s",typeProp);
		if (varNameValue != null) {
			configuration.setProperty(propertyName, varNameValue);
		} else {
			String hibernatePropertyVal = configuration.getProperty(propertyName);
			if (hibernatePropertyVal == null) {
				String error_message = String.format("Please check '%s' in your local environment variable or "
                	+ "'hibernate.connection.%s' in your 'hibernate.properties' file!", varname, typeProp);
            	System.out.println(error_message);
			}
		}
	}

	// if the env variable for server host is null, use localhost instead.
    public static String getEnvVariableHostAddress(String varname_host){
            String hostAddress = System.getenv(varname_host)  != null ? System.getenv(varname_host) : "localhost"; // Host
            return hostAddress;
    }

    // try if the environment variable for port number is null, use 7776 instead
    public static int getEnvVariablePortNumber(String varname_port){
            String portNum = System.getenv(varname_port)  != null? System.getenv(varname_port)  : "7776"; //PORT
            int portNumInt = Integer.parseInt(portNum);
            return portNumInt;
    }

	public static void setCors() {
    	Properties properties = new Properties();
        String propertyValue = "";
        
        try (FileInputStream fileInput = new FileInputStream("cors.properties")) {
            properties.load(fileInput);
            propertyValue = properties.getProperty("allowedMethod");
            VMJCors.setAllowedMethod(propertyValue);
            
            propertyValue = properties.getProperty("allowedOrigin");
            VMJCors.setAllowedOrigin(propertyValue);
            
        } catch (IOException e) {
			VMJCors.setAllowedMethod("GET, POST, PUT, PATCH, DELETE");
			VMJCors.setAllowedOrigin("*");
			System.out.println("Buat file cors.properties terlebih dahulu pada src-gen/(namaProduk) dengan contoh sebagai berikut:");
			System.out.println("allowedMethod = GET, POST");
			System.out.println("allowedOrigin = http://example.com");
        }
    }


}