package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertSample {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {
		// Step 1) Launch the web browser and open the site
		// "http://demo.guru99.com/test/delete_customer.php "
		driver.get("http://demo.guru99.com/test/delete_customer.php ");
		// Step 2) Enter Any Customer id.
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("123");
		// Step 3) After entering the customer ID, Click on the "Submit" button.
		driver.findElement(By.xpath("//input[@name='submit']")).submit();
		// Step 4) Reject/accept the alert.
		Alert alertmess = driver.switchTo().alert();
		alertmess.getText();
		System.out.println(alertmess);
		Thread.sleep(5000);
		alertmess.accept();

	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.firefoxdriver().setup();

	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
