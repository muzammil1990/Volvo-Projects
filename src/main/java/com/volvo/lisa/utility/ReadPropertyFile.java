/**
 * 
 */
package com.volvo.lisa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class is used to read the data from the property file
 */
public class ReadPropertyFile {

    String data;

    // This method is used to read the property file.
    public String readDataFromPropertiesFile(String filePath, String key) {
        try {
            File file = new File(filePath);                     // File class to access file location
            FileInputStream fis = new FileInputStream(file);    // FileInputStream class will read all types of file like audio/video/img.   FileInputStream</code> is meant for reading streams of raw bytes such as image data. For reading  streams of characters, consider using <code>FileReader</code>.
            Properties prop = new Properties();                 // to read the file as property file
            prop.load(fis);
            data = prop.get(key).toString();                    //picks key value
        } catch (Exception e) {
            e.getMessage();
        }
        return data;
    }
}
