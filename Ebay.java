package pe.com.test;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Ebay {

	private WebDriver driver;
	private String urlInicial = "https://demo.evershop.io";

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\ProgramasInstalados\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}
	
	@Test
	public void HomePage_FlujoBasico() throws Exception {
		try {
			
			driver.get(urlInicial);
			
			Thread.sleep(5000);
		
			//driver.findElement(By.className("mini-cart-icon")).click(); 
			Thread.sleep(5000);
			
			driver.findElement(By.cssSelector("a[href='/account/login'] svg")).click();
			Thread.sleep(1000);
			
			//driver.findElement(By.cssSelector("a[href='/account/register']")).click();
			//createAccount("Maria Mendez",getSaltString()+"@gmail.com", "mmendez1234");
			
			login("mmendez@gmail.com", "mmendez1234");
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("button[class='button primary']")).click();
			
			
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector("a[href='/women']")).click();
			Thread.sleep(5000);
			
								

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	//Login
	public void login(String email, String password) {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println(email);
		System.out.println(password);
	}

	//Create account
	public void createAccount(String full_name, String email, String password) {		
		driver.findElement(By.name("full_name")).sendKeys(full_name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[class='button primary']")).click();
	}
	
	//Random email
	protected String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }	
	
	
	
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}
}