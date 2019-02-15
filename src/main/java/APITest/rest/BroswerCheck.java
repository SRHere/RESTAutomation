package APITest.rest;

import gridnodes.StepLib.BROWSERNAME;
import gridnodes.StepLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;

public class BroswerCheck {

	public static Properties getProperty() throws IOException  {
		InputStream is = null;
		Properties prop = new Properties();
		ResourceBundle rbi = ResourceBundle.getBundle("check/config");
		String chromestarter = rbi.getString("drivepath");
		try {
			is = new FileInputStream(new File(chromestarter));
			prop.load(is);
		} finally {
			if (null != is) {
				is.close();
			}
			is = null;
		}
		return prop;
	}
}
