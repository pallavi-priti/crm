package com.odoo.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLib {
	
	private WebDriver driver;
	
	
	public PageLib(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void jsClick(String xpath){
		
	    
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", driver.findElement(By.xpath(xpath)));
		
		
	}
	public void jsScrollIntoView(String xpath){
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath(xpath)));
		
		
	}
	public void jsSetAttribute(String xpath,String input){
		
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].setAttribute('value','"+input+"')", driver.findElement(By.xpath(xpath)));
		
	}
	public void selectOptionByText(WebElement dropDown,String text){
		
		Select sel=new Select(dropDown);
		sel.selectByVisibleText(text);
		
	}
	public void selectOptionByIndex(WebElement dropDown,int index){
		
		Select sel=new Select(dropDown);
		sel.selectByIndex(index);
	}
	public void dragAndDrop(WebElement source,WebElement target){
		
		Actions act=new Actions(driver);
		act.clickAndHold(source).perform();
		act.dragAndDrop(source, target).perform();
		act.release(source).perform();
	}
	public void eWaitForElementPresent(int seconds,String xpath){
		WebDriverWait wait=new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public void eWaitForElementVisible(int seconds,String xpath){
		WebDriverWait wait=new WebDriverWait(driver,seconds);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	


