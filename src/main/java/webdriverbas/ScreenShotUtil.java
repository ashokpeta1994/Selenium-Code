package webdriverbas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShotUtil {

	WebDriver driver;

	/**
	 * This is the default constructor of the class
	 *
	 * @param driver
	 */
	public ScreenShotUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to get the screenshot of a particular page
	 *
	 * @param driver
	 * @param fileName
	 */
	public void takePageScreenShot(String fileName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./target/screenshots/" + fileName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the screenshot of a particular WebElement in a
	 * page
	 *
	 * @param driver
	 * @param fileName
	 */
	public void takeElementScreenShot(WebElement element,String fileName) {
		File src = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./target/screenshots/" + fileName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

