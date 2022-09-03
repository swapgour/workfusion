/**
 * 
 */
package utils;

/**
 * @author SWAPNIL GOUR
 *
 */

import java.io.*;
import java.util.*;

import constants.Constants;

public class ReadPropertiesFileTest 
{
	public static void main(String args[]) throws IOException {
		Properties prop = readPropertiesFile(Constants.filePath);
		System.out.println("username: " + prop.getProperty("usernameID"));
		System.out.println("fullname: " + prop.getProperty("fullnameXpath"));
	}

	public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}
}