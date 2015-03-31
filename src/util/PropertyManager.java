package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager{
	
    public static Properties prop = new Properties();
    
	static{
		try {
			prop.load(PropertyManager.class.getClassLoader().getResourceAsStream("config/snake.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String s){
		return prop.getProperty(s);
	}
		
}
