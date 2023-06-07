package utilityClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class KeywordDriven {
	public static void main(String[] args) throws Throwable {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("./prop/global.properties");
		p.load(fis);
		String URL = p.getProperty("url");
		System.out.println(URL);
		String UN = p.getProperty("un");
		System.out.println(UN);
	String PWD=	p.getProperty("pwd");
	System.out.println(PWD);
	
	p.setProperty("un", "java");
	p.setProperty("pwd", "javaScript");
	FileOutputStream fos=new FileOutputStream("./prop/global.properties");
	p.store(fos, "for security purpose new username and pasword added");
	System.out.println(p.getProperty("un"));
	Enumeration<String> names=(Enumeration<String>) p.propertyNames();
	System.out.println(names);
	while(names.hasMoreElements())
	{
	String ele=	names.nextElement();
	System.out.println("the elements present on list "+ele);
	}
	
	
	}
}
