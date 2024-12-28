package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstract.Abstract;

public class Login extends Abstract {

	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement Email;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;

	
	public ProdPage LoginUrl(String email, String pass) {
		Email.sendKeys(email);
		password.sendKeys(pass);
		login.click();
		ProdPage prod =new ProdPage(driver);
		return prod;
	}

	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
