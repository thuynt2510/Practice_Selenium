package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Session5 {
	WebDriver driver;

	// WebDriver chr_driver;
	@BeforeTest
	@Parameters({ "browser" })
	public void setup(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Firefox"))

		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}

		else if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

	}

	@Test
	public void TC_Upload_file_Sendkey() throws InterruptedException {

		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// Step 2: Sửdụngsendkeyđể upload files trên 2 trìnhduyệt( firefox, chrome)

		String path = "D:\\Chau\\";

		int i = 1;
		while (i < 3) {

			WebElement add_file = driver.findElement(By.xpath("//input[@name='files[]']"));
			add_file.sendKeys(path + "image" + i + ".jpg");
			Thread.sleep(3000);
			// Step3: Kiểm tra file hiển thị trên trang
			WebElement img1_display = driver.findElement(
					By.xpath("//tr[" + i + "][@class='template-upload fade in']/child::td[" + (i + 1) + "]/p"));
			Thread.sleep(3000);
			img1_display.isDisplayed();

			i++;
		}

		// Step 4: Click Start upload và verify files được upload thànhcông
		WebElement btn_upload = driver.findElement(
				By.xpath("//i[@class='glyphicon glyphicon-upload']//following-sibling::span[text()='Start upload']"));
		btn_upload.click();
		Thread.sleep(5000);

		// verify file upload thành công

		List<WebElement> list = driver.findElements(By.xpath("//button[contains(@data-url,'image')]"));

		System.out.println("Tong cac file upload thanh cong : " + list.size());

		for (int j = 0; j < list.size(); j++) {
			System.out.println("Kiem tra file upload co ten image" + (j + 1) + ".jpg:"
					+ list.get(j).getAttribute("data-url").contains("image" + (j + 1) + ".jpg"));

		}
		System.out.println("Upload successfully");

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		// chr_driver.quit();

	}

}
