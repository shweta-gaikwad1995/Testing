package com.page.layer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Layer.BaseLayer;

public class HomePage extends BaseLayer{
	
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[text()='Components']")
	WebElement compoenets;
	
	private By monitors=By.xpath("//a[text()='Monitors (2)']");
	
	
//==============================================================
	
	public ProductCategoryPage Compoenets() throws IOException
	{
		Actions act=new Actions(driver);
		act.moveToElement(compoenets).perform();
		driver.findElement(monitors).click();
		return new ProductCategoryPage();
	}
	
}
