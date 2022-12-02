package com.waitutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions acts = new Actions(driver);

		WebElement ele = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input"));
		WebElement e = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[1]"));

		ele.sendKeys("Ashok Peta");

		acts.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		acts.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

		e.click();

		acts.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

		driver.quit();
	}

}
