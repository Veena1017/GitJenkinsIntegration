package PageObjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.Abstract;

public class ProdPage extends Abstract {

	WebDriver driver;

	public ProdPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By Product = By.cssSelector(".mb-3");

	By cart = By.cssSelector(".card-body button:last-of-type");

	By toast = By.cssSelector("#toast-container");

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy(xpath ="//button[@routerlink='/dashboard/cart']")
	WebElement MainCart;

	public List<WebElement> getprodlist() {
		WaitForElementToVisible(Product);
		return products;
	}

	public WebElement getprodbyname(String ProductName) {
		WebElement prod = getprodlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addtocart(String ProductName) {
		WebElement prod = getprodbyname(ProductName);
		prod.findElement(cart).click();
		WaitForElementToVisible(toast);
		WaitForInvisible(spinner);

	}

	public void ClickCart() {
		
		MainCart.click();

	}

}
