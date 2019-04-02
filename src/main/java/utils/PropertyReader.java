package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static Properties prop;
	public static FileInputStream inputStream;
	
	public static String ReadProperty(String PropertyName) throws IOException{
		
		prop = new Properties(); //Reading from properties file ---> create an instance Properties class
		//String projectpath = System.getProperty("user.dir");//Project Path
		//System.out.println("Project Path : "+ projectpath);
		//the below statement is going to open the file in read mode
		//inputStream = new FileInputStream(projectpath + "/src/com/project/config/config.properties");
		inputStream = new FileInputStream("C:\\Users\\phallammark\\eclipse-workspace\\seleniumProjectDay4\\src\\test\\resources\\config.properties");
		//we need to load the properties file
		prop.load(inputStream);
		String PropertyValue = prop.getProperty(PropertyName);
		return PropertyValue;		
	}
	
	public static void main(String args[]) throws IOException{
		System.out.println(PropertyReader.ReadProperty("browser"));
		System.out.println(PropertyReader.ReadProperty("appurl"));
	}

}
