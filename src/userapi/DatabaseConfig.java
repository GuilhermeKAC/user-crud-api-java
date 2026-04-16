package userapi;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader()
                .getResourceAsStream("resources/application.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo application.properties não encontrado");
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUser() {
        return properties.getProperty("db.user");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
}