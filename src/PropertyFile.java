import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Properties;

/*
    for the use of a config file
 */
class PropertyFile {
    /* Members */
    Properties prop;

    //Constructor
    PropertyFile() throws FileNotFoundException {
        //Create new properties object
        prop = new Properties();

        //Get properties file
        FileInputStream ip = new FileInputStream("resources/config.properties");

        //Load the properties file
        try {
            prop.load(ip);

            System.out.println("Outfile Dir: " + prop.getProperty("outfileDir"));
            System.out.println("Image Dir: " + prop.getProperty("imageDir"));
            System.out.println("CSV Location: " + prop.getProperty("csvLocation"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void WriteField(String fieldName, String value) throws FileNotFoundException {
        //Get properties file
        FileInputStream ip = new FileInputStream("resources/config.properties");

        //Set property
        prop.setProperty(fieldName, value);
    }
}
