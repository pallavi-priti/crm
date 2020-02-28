package com.odoo.webutils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public class OdooListeners implements ITestListener,WebDriverEventListener
{
	
	
	public static int executionCount,passCount,failCount,skipCount=0;
	public static Logger log;
	long startTime;
	//WebDriver driver;
	
	
	public void onStart(ITestContext context,WebDriver driver) 
	{
		 startTime = System.currentTimeMillis();
		
		System.setProperty("logpath",GenericLib.dir+"/reports/logfiles");
		 System.setProperty("htmlpath",GenericLib.dir+"/reports/htmlreports");
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		System.setProperty("timestamp",sdf.format(new Date()));
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger("OdooListener.class");
		log.info("Suit Execution starts ");
		String plateformName=System.getProperty("plateform");
		String browserName=System.getProperty("browser");
		String headless=System.getProperty("headless");
		//System.getProperty("headless");
		
		
	        BrowserFactory.launchBrowser(plateformName, browserName, headless);
					log.info(browserName+"launched in"+plateformName+"plateform and headless:"+headless);
		
		       Driver.setDriver(driver);
		      }
	
public void onFinish(ITestContext context) {
		
		long stopTime = System.currentTimeMillis();
		double totalTime = (stopTime-startTime)/1000;//widening-to get ans in points as devide by 1000
		log.info("Total suite execution time:"+totalTime+"seconds");
		
		log.info("Suite Execution ends");
		Driver.getDriver().close();
		log.info("Browser Closed");
		log.info("total script executed:+"+executionCount);
		log.info("total scripts passed:"+passCount);
		log.info("total script failed:"+failCount);
		log.info("total script skipped:"+skipCount);
		
	}
       public void onTestStart(ITestResult result) {
	
	      executionCount++;
	      log.info(result.getName()+"script execution starts");
	      }
        
       
      public void onTestSuccess(ITestResult result) {
		
		passCount++;
		log.info(result.getName()+"script is pass");
		}
	
	public void onTestSkipped(ITestResult result) {
		
		skipCount++;
		log.warn(result.getName()+"script is skipped");
		
		
	}
	
	
	public void onTestFailure(ITestResult result) {
		failCount++;
		log.error(result.getName()+"script is failed");
		TakesScreenshot ts=(TakesScreenshot)Driver.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(GenericLib.dir+"screenshots/"+result.getName()+".png");
		
		try {
			Files.copy(srcFile, destFile);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		log.info("screenshot has been taken");
	}
	
     public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    	 
		log.info("Finding Element with locators:"+by);
		
	}
     public void onException(Throwable t, WebDriver driver) {
 		
 		log.fatal(t.getMessage());
 	}
 	
	
	
	
	

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
		
	
	

}
