package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNGDemo;

public class Propertiesfile {

	static Properties prop=new Properties();
	static String filePath=System.getProperty("user.dir");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
		getProperties();
		
	}

	public static void getProperties()
	{
		try {
			
			InputStream ip=new FileInputStream(filePath+"/src/test/java/config/config.properties");
			prop.load(ip);
			String browser=prop.getProperty("browser");
			System.out.println(browser);
			TestNGDemo.browserName=browser;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	
	public static void setProperties() {
		try {
			
			OutputStream out=new FileOutputStream(filePath+"/src/test/java/config/config.properties");
			prop.setProperty("result", "pass");
			prop.setProperty("browser", "chrome");
			prop.store(out, null);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}
