package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

public static Properties getLoadedPropertiesObject() throws IOException {
    // 1 . read the file
    FileInputStream fp = new FileInputStream("config/config.properties");
    //2. create the object of properties class and load it with the file
    // object
    Properties prop = new Properties();
    prop.load(fp);

    return prop;
}

    public static String getUrl() throws IOException {

        return  getLoadedPropertiesObject().getProperty("url");
    }


public static String getUsername() throws IOException {

        return  getLoadedPropertiesObject().getProperty("username");
    }

    public static String getPassword() throws IOException {

        return  getLoadedPropertiesObject().getProperty("password");
    }




}
