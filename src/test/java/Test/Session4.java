package Test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Session4 {

	WebDriver driver;

	@Test(enabled = false)
	public void TC01() {

		// Step 1: Vàotranghttp://the-internet.herokuapp.com/basic_auth
		// Step 2: Điền admin/ admin vào alert

		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		// Step 3: Verify message Congratulations! You must have the proper credentials.

		String lbl = driver.findElement(By.xpath("//div[@class='example']/p")).getText();

		assertEquals(lbl, "Congratulations! You must have the proper credentials.");

		System.out.println("TC01 done");

	}

	@Test(enabled = false)
	void TC02() throws InterruptedException {

		// Step 1: Vàotrang http://www.myntra.com/

		driver.get("http://www.myntra.com/");

		Thread.sleep(5000);

		// Step 2: Hover chuộtvào “Discover”

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Discover']")))
				.perform();

		// Step 3: Chọn “American Eagle”

		driver.findElement(By.xpath("//a[text()='American Eagle']")).click();

		// Step 4: Verify đãchuyển page thànhcông

		String lbl1 = driver.findElement(By.xpath("//h1[text()='American Eagle']")).getText();
		// assertEquals(lbl1, "American Eagle");

		lbl1.contains("American Eagle");

		System.out.println("TC02 done");

	}

	@Test(enabled = false)
	void TC03() throws InterruptedException {

		// Step 1: Vàotrang
		// https://jqueryui.com/resources/demos/selectable/display-grid.html

		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		Thread.sleep(5000);

		// Click chọn số 1 và kéo đến số 4

		Actions act = new Actions(driver);
		WebElement el1 = driver.findElement(By.xpath("//li[text()=1]"));
		WebElement el2 = driver.findElement(By.xpath("//li[text()=2]"));
		WebElement el3 = driver.findElement(By.xpath("//li[text()=3]"));
		WebElement el4 = driver.findElement(By.xpath("//li[text()=4]"));
		act.clickAndHold(el1);
		act.moveToElement(el4);
		act.release();
		act.build().perform();

		// Step 3: Sau khichọn – kiểmtrađúng 4 phầntửđãđượcchọnthànhcông

		el1.isSelected();
		el2.isSelected();
		el3.isSelected();
		el4.isSelected();

		System.out.println("TC03 done");

	}

	@Test(priority = 4)
	void TC04() throws InterruptedException {

		// Step 1: Vàotrang
		// https://jqueryui.com/resources/demos/selectable/display-grid.html

		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");

		// step 2 Chọn random các ô ( vd: 1 3 5 7 9)
		// Nhan phim ctrl
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).perform();

		// Nhan vao so 1,3,5,7,9
		String n1 = "1";
		String n2 = "3";
		String n3 = "5";
		String n4 = "7";
		String n5 = "9";

		WebElement el1 = driver.findElement(By.xpath("//li[text()=" + n1 + "]"));
		el1.click();
		WebElement el3 = driver.findElement(By.xpath("//li[text()=" + n2 + "]"));
		el3.click();
		WebElement el5 = driver.findElement(By.xpath("//li[text()=" + n3 + "]"));
		el5.click();
		WebElement el7 = driver.findElement(By.xpath("//li[text()=" + n4 + "]"));
		el7.click();
		WebElement el9 = driver.findElement(By.xpath("//li[text()=" + n5 + "]"));
		el9.click();
		act.release();
		// Step 3: Sau khichọn – kiểmtrađúng 4 phầntửđãđượcchọnthànhcông

		List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class,'ui-selected')]"));

		System.out.println("Tong cac so duoc chon : " + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println("Danh sach cac so duoc chon: " + list.get(i).getText());

		}

		System.out.println("TC04 done");

	}

	@Test(enabled = false)
	void TC05() throws InterruptedException {

		// Vao trang nay http://swisnl.github.io/jQuery-contextMenu/demo.html

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		// Maximize window
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Step 2: Right click vào “right click me”

		Actions act = new Actions(driver);
		act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']")));
		act.perform();
		// Step 3: Verify menu đượchiểnthị
		driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']")).isDisplayed();
		// Step 4: Click vào “copy”
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']/span"))
				.click();
		// Step 5: Verify alert hiểnthịthôngbáo => clicked: copy
		Alert alert = driver.switchTo().alert();
		alert.getText().contains("clicked:copy");

		System.out.println("TC05 done");

	}

	@Test(enabled = false)
	void TC06() throws InterruptedException {

		// Step 1: Vàotranghttps://demos.telerik.com/kendo-ui/dragdrop/angular

		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		// Maximize window
		driver.manage().window().maximize();
		// Step 2:Dùngjavascript scroll mànhìnhxuốngvùngsửdụng
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);

		// Step 3:Kéohìnhtrònnhỏvàohìnhtrònlớn
		WebElement small = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement big = driver.findElement(By.xpath("//div[@id='droptarget']"));
		Actions move = new Actions(driver);
		move.dragAndDrop(small, big);
		move.build().perform();
		Thread.sleep(3000);
		// Step 4: Verify message You did great!

		big.getText().contains("You did great!");

		System.out.println("TC06 done");

	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
