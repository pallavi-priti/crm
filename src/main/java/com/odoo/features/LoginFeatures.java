package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.LoginSteps;

import io.qameta.allure.Story;

public class LoginFeatures {
	
	LoginSteps ls; 
	public LoginFeatures(WebDriver driver){
		
		ls=new LoginSteps(driver);
		}
	@Story("performing login using credential {0}and {1}")
	public void login(String username,String password){
		
		ls.enterusername(username);
		ls.enterPassword(password);
		ls.clickLoginBtn();
	}
	
	

}
