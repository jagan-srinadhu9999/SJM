package utilityClasses;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {
	public String fetchProperty(String key) throws Exception{ 
    
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("./props/loginCred.properties");
		p.load(fis);
		
	String data=p.getProperty(key);
	return data;
	}
	
}
