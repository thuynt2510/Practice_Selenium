package Test;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Session3 {

	WebDriver driver;
	String URL_Home = "https://demo.guru99.com/V4/index.php";
	public static int num = 0;

	@Test(priority = 2)
	public void TC_01() throws InterruptedException {
		// Step 1 : navigate https://demo.guru99.com/V4/index.php
		driver.get(URL_Home);
		Thread.sleep(3000);
		// Step 2 : Click Visit Here
		driver.findElement(By.xpath("//a[text()='here']")).click();
		Thread.sleep(3000);
		// Step 3 :input email
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("vsiitest01@gmail.com");
		// Step 4 : Click submit
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Thread.sleep(3000);
		// Get userID
		String useid = driver
				.findElement(By.xpath("//td[@class='accpage' and text()='User ID :']//following-sibling::td"))
				.getText();
		System.out.println(useid);
		// Get password
		String pwd = driver
				.findElement(By.xpath("//td[@class='accpage' and text()='Password :']//following-sibling::td"))
				.getText();
		System.out.println(pwd);
		// return home;
		Thread.sleep(3000);
		driver.navigate().to(URL_Home);
		Thread.sleep(3000);
		// Step 5 :login with user/pass
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(useid);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).submit();
		Thread.sleep(3000);
		// Step 6 : Click new customer
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		// Step 7 : input customer registration
		// customer name
		String cus_name = "thuynt";
		String dob = "1983-10-25";
		String address = "Nguyen Hoang Ton";
		String city = "Ha noi";
		String state = "NA";
		String pin = "123456";
		String tel = "0936984868";
		String email = "thuynt" + random(num) + "@gmail.com";
		String pass = "123456";
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(cus_name);
		// gender
		driver.findElement(By.xpath("//input[@value='f']")).click();
		Thread.sleep(3000);
		String gen_bef = driver.findElement(By.xpath("//input[@value='f']")).getAttribute("value");
		System.out.println(gen_bef);
		// DoB
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(dob);
		// address
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(address);
		// city
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		// sate
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		// pin
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pin);
		// mobile number
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(tel);
		// email
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		// password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		// step 8: click submit
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		Thread.sleep(3000);

		// Verify Customer Registered Successfully!!!
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText(),
				"Customer Registered Successfully!!!");

		System.out.println(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText());
		// Verify all fields compared to input information

		Assert.assertEquals(
				driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td")).getText(),
				cus_name);
		System.out
				.println(driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td")).getText());

		// lay ki tu dau tien cua chuoi gender tren trang xac nhan
		String gen_aft = driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td")).getText()
				.substring(0, 1);
		System.out.println(gen_aft);
		// So sanh value cua gender voi ki tu dau tin trong chuoi gender
		Assert.assertEquals(gen_aft, gen_bef);

		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td")).getText(),
				dob);
		System.out.println(driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td")).getText());

		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText(),
				address);
		System.out.println(driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']//following-sibling::td")).getText(), city);

		System.out.println(driver.findElement(By.xpath("//td[text()='City']//following-sibling::td")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']//following-sibling::td")).getText(),
				state);
		System.out.println(driver.findElement(By.xpath("//td[text()='State']//following-sibling::td")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td")).getText(), pin);
		System.out.println(driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td")).getText(),
				tel);
		System.out.println(driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']//following-sibling::td")).getText(),
				email);
		System.out.println(driver.findElement(By.xpath("//td[text()='Email']//following-sibling::td")).getText());

		System.out.println("Hoan thanh TC_01!!!!!!!!!!!");

	}

	@Test(priority = 1)
	public void TC_02() throws InterruptedException {
		// Step 1: Vao trang https://demo.nopcommerce.com/register
		driver.get("https://demo.nopcommerce.com/register");
		// Step 2: Click Register tren dau trang
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		// Step 3: Fill in form
		String f_name = "Nguyen";
		String l_name = "Thu Thuy";
		String email = "vsiitest" + random(num) + "@gmail.com";
		String comp_name = "ABC corp";
		String pwd = "123456";
		String cf_pwd = pwd;

		// Gender
		driver.findElement(By.xpath("//input[@value='F']")).click();
		// Firstname
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(f_name);
		// Lastname
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(l_name);
		// DOB
		Select sel_day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		sel_day.selectByValue("25");

		Select sel_mon = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		sel_mon.selectByValue("10");
		Select sel_year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		sel_year.selectByValue("1983");
		// Email
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		// Company Name
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(comp_name);
		// Newsletter
		driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		// Password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		// Confirm Password
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(cf_pwd);
		// click on Register button
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		Thread.sleep(3000);
		// Step 5 : Verify text Your registration completed
		driver.findElement(By.xpath("//div[@class='result']")).isDisplayed();
		// get text hien thi tren ket qua
		String lbl_infor = driver.findElement(By.xpath("//div[@class='result']")).getText();
		Assert.assertEquals(lbl_infor, "Your registration completed");

		System.out.println("Hoan thanh TC_02!!!!!!!!!!!!");

	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	public int random(int num) {
		Random ran = new Random();
		num = ran.nextInt(99999);
		return num;

	}

}
