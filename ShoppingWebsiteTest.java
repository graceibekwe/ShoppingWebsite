package ShoppingWebsite;

import static org.junit.Assert.*;

//import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ShoppingWebsiteTest {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test 
	@Ignore 
	public void search() {
		driver.get("http://automationpractice.com/index.php");
		
		WebElement searchBar = driver.findElement(By.id("search_query_top"));
		searchBar.sendKeys("dress");
		
		WebElement searchBtn = driver.findElement(By.name("submit_search"));
		searchBtn.submit();
		
		WebElement result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		
		assertEquals("Did not find the item", "Printed Summer Dress", result.getText());
	}
	
	@Test 
	@Ignore 
	public void addToCart() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		WebElement searchBar = driver.findElement(By.id("search_query_top"));
		searchBar.sendKeys("dress");
		WebElement searchBtn = driver.findElement(By.name("submit_search"));
		searchBtn.submit();
		
		WebElement result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")); 
		result.click();
		
		WebElement addCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
		addCart.submit();
		
		Thread.sleep(2000);
//		List<WebElement> wes = driver.findElements(By.tagName("a"));
//			for (WebElement item : wes) {
//				if (item.getAttribute("src").equals("")) {
//					item.click();
//				}
//			}
			
		
		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"product_5_19_0_0\"]/td[2]/p/a"));

		assertEquals("Did not add to cart", "Printed Summer Dress", confirm.getText());
	}
	
	@Test 
	public void checkout() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		WebElement searchBar = driver.findElement(By.id("search_query_top"));
		searchBar.sendKeys("dress");
		WebElement searchBtn = driver.findElement(By.name("submit_search"));
		searchBtn.click();
		WebElement result = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")); 
		result.click();
		WebElement addCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
		addCart.submit();
		Thread.sleep(2000);
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		checkout.click();
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email_create\"]"));
		email.sendKeys("gldn5@gmail.com");
		WebElement create = driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		create.submit();
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
		name.sendKeys("grace");
		WebElement surname = driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
		surname.sendKeys("london");
		WebElement pw = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		pw.sendKeys("lalala");
		WebElement name2 = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		name2.sendKeys("grace");
		WebElement surname2 = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		surname2.sendKeys("london");
		WebElement address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		address.sendKeys("where i live");
		
		WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		city.sendKeys("London");
		
		WebElement state = driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
		state.click(); 
		WebElement myState = driver.findElement(By.xpath("//*[@id=\"id_state\"]/option[2]"));
		myState.click();
		
		WebElement zip = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
		zip.sendKeys("90210");
		//WebElement country = driver.findElement(By.xpath("//*[@id=\"id_country\"]"));
		//leave country
		WebElement mobile = driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
		mobile.sendKeys("0796464879");
		WebElement ref = driver.findElement(By.xpath("//*[@id=\"alias\"]"));
		ref.sendKeys("home");
		
		WebElement register = driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
		register.click();
		
		
		WebElement proceed = driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
		proceed.click();
		
		WebElement tncs = driver.findElement(By.xpath("//*[@id=\"cgv\"]"));
		tncs.click();
		
		Thread.sleep(2000);
		WebElement proceed2 = driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
		proceed2.click();
		Thread.sleep(2000);
		
		//works up to here
		WebElement payCard = driver.findElement(By.className("bankwire"));
		payCard.click();
		Thread.sleep(4000);
		WebElement proceed3 = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
		proceed3.click();
		Thread.sleep(4000);
		
		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));
		
		assertEquals("Did not complete checkout", "Your order on My Store is complete.", confirm.getText());
	}
	
	@After
	public void teardown() {
		driver.close();
	}
}
