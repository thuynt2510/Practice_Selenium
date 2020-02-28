package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	String url_login = "http://live.demoguru99.com/index.php/customer/account/login/";
	String url_register_page = "http://live.demoguru99.com/index.php/customer/account/create/";
	String lnk_my_acc = "//div[@class='footer-container']//descendant::a[@title='My Account']";
	String btn_create_new_acc = "//a[@title='Create an Account']";

	@Test
	public void TC_01() throws InterruptedException {

		// click My Account at footeraa

		driver.findElement(By.xpath(lnk_my_acc)).click();
		// wait 3s

		Thread.sleep(3000);

		// verify URL login page

		assertEquals(driver.getCurrentUrl(), url_login);

		// click [Create an Account] button
		Thread.sleep(3000);

		driver.findElement(By.xpath(btn_create_new_acc)).click();
		// Verify urlcUa Register Page
		Thread.sleep(3000);

		assertEquals(url_register_page, driver.getCurrentUrl());

	}

	@Test
	public void TC_02() throws InterruptedException {

		// click My Account at footer

		driver.findElement(By.xpath(lnk_my_acc)).click();
		// wait 3s

		Thread.sleep(3000);

		// verify title of login page:Customer Login

		assertEquals("Customer Login", driver.getTitle());

		// click [Create an Account] button
		Thread.sleep(3000);

		driver.findElement(By.xpath(btn_create_new_acc)).click();

		// Verify title of registration page : Create New Customer Account
		Thread.sleep(3000);
		assertEquals(driver.getTitle(), "Create New Customer Account");

	}

	@Test
	public void TC_03() throws InterruptedException {

		// • Step 02 - Click MOBILE

		driver.findElement(By.xpath("//*[text()='Mobile']")).click();
		// wait 3s

		Thread.sleep(3000);

		// step 03- Click Add To Cart cho Samsung Galaxy

		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']//parent::h2/following-sibling::div/button")).click();

		// Find cart element number and get value

		String cart_val = driver.findElement(By.xpath("//span[@class='count']")).getText();

		// Step 04–Verify Cart hienthi = Cart (1)

		assertEquals(cart_val, "1");

	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();

		// driver = new ChromeDriver();

		// driver = new InternetExplorerDriver();

		// navigate to http://live.guru99.com/

		driver.get("http://live.guru99.com/");

	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
