package config;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.Login;

public class Base {

	public WebDriver driver;
	public Login login;

	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Veena\\eclipse-workspace\\Sample\\src\\Config.properties");
		prop.load(fis);

		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
//Run Before Method
	@BeforeMethod
	public Login launchApplication() throws IOException
	{
		driver = InitializeDriver();
		login = new Login(driver);
		login.GoTo();
		return login;
	}
	
	@AfterMethod
	public void CloseDriver()
	{
		driver.close();
			
	}
}
