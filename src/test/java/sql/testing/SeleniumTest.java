package sql.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	static WebDriver driver;
	public static String DB_URL = "jdbc:mysql://localhost:3306/seleniumdata";
	//Database Username
	public static String DB_USER = "root";
	// Database Password
	public static String DB_PASSWORD = "vrushali1234";
	
	private static Statement stmt;
	
	String login_UserNameID="Chris";
	String login_LastName="1234";
	boolean status=false;
	
	
	@Test
	public void m1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/login");
		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(login_UserNameID);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(login_LastName);
		
		
		
		
		
		
		// Database connection
		String dbClass = "com.mysql.cj.jdbc.Driver";
		Class.forName(dbClass).newInstance();
		// Get connection to DB
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		// Statement object to send the SQL statement to the Database
		stmt = con.createStatement();
		
		String query="select UserNameID,LastName from login";
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next())
		{
			String UserNameID=rs.getString("UserNameID");
			String LastName=rs.getString("LastName");
			
		System.out.print("\t"+UserNameID);
		System.out.println("\t"+LastName);
		
		if(login_UserNameID.equals(UserNameID)&&login_LastName.equals(LastName))
		{
			System.out.println("Test Passed");
			status=true;
			break;
			
		}
		
		if(status==false)
		{
			System.out.println("Failed");
		}
		}
	
	}
		
}
