package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() 
	{
		File src=new File("./Configuration/config.properties");
		
			try {
				FileInputStream fis =new FileInputStream(src);
				pro= new Properties();
				try {
					pro.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

public String getApplicationUrl()
{
	String url=pro.getProperty("baseurl");
	return url;
	
}
public String getUserName()
{
	String usn=pro.getProperty("Username");
	return usn;
}
public String getPassword()
{
	String pwd=pro.getProperty("Password");
	return pwd;
}
public String getChromePath()
{
	String chrmpath = pro.getProperty("chromepath");
	return chrmpath;
}

public String getFirefoxPath()
{
	String firefoxpath = pro.getProperty("firefoxpath");
	return firefoxpath;
}
}
