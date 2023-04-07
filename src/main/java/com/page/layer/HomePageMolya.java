package com.page.layer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Layer.BaseMooolya;

public class HomePageMolya  extends BaseMooolya{
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[starts-with(text(),'Login')]")
	WebElement loginButton;
	

	public HomePageMolya() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void getTitle1()
	{
		driver.getTitle();
	}
	
	public MoolyaHomePage landingmoolya()
	{
		username.sendKeys("9876543211");
		password.sendKeys("admin");
		loginButton.click();
		return new MoolyaHomePage();
		
	}

	
}
