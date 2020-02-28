package com.odoo.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver launchBrowser(String plateformName,String browserName,String headless){
		
		WebDriver driver=null;
		
	if(plateformName.equalsIgnoreCase("Windows")||plateformName.contains("Windows"))
	{
		if(browserName.equalsIgnoreCase("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
		}
	}
		else if(plateformName.equalsIgnoreCase("Linux")||plateformName.contains("Ubuntu"))
		{
			if(browserName.equalsIgnoreCase("chrome")){
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
			}
			else if(browserName.equalsIgnoreCase("firefox")){
				
				
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
			}
		}
		
			else if(plateformName.equalsIgnoreCase("Mac")||plateformName.contains("Mac"))
			{
				if(browserName.equalsIgnoreCase("chrome")){
					
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver(ChromeCapabilities.getChromeSettings(headless));
				}
				else if(browserName.equalsIgnoreCase("firefox")){
					
					
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver(FirefoxCapabilities.getFirefoxSettings(headless));
				}
			}
				
			return driver;	
				
			}
				
		}
		
		
	
		
		
		

		
		
	


