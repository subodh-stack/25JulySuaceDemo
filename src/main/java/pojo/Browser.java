package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver openChromeBrowser()  {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notications");
		//options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
	
		driver.navigate().to("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
				
		return driver;
	
	}
}
