import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import PageObjects.ProdPage;
import config.Base;

public class StanAloneTest extends Base{

	@Test
	public void SubmitOrder() throws IOException {

		String ProductName = "IPHONE 13 PRO";
		ProdPage prod = login.LoginUrl("veena1017@gmail.com", "Vee@1017");
		List<WebElement> products = prod.getprodlist();
		prod.getprodbyname(ProductName);
		prod.addtocart(ProductName);
		prod.ClickCart();

	}
}
