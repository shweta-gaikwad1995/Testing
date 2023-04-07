package com.test.layer;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Layer.BaseLayer;
import com.page.layer.HomePage;

public class HomePageTest extends BaseLayer{
	
	HomePage homepage;
	
	public HomePageTest() throws IOException
	{
		super();
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		intialization();
		homepage=new HomePage();
	}
	
	/**
	 * Navigate to “Components’ 
	 * Menu and select “Monitors” submenu option
	 * @throws IOException 
	 */
	@Test
	public void Componenets() throws IOException
	{
		homepage.Compoenets();
	}
}
