package webdriverbas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtil {

	WebDriver driver;

	/**
	 * This method is the default constructor of the class
	 *
	 * @param driver
	 */
	public GenericUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to get the url of a particular web page
	 *
	 * @param url
	 */
	public void getUrl(String url) {
		driver.get(url);
	}

	/**
	 * This method is used to find and store a particular WebElement
	 *
	 * @param driver
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * This method is used to click on a particular WebElement
	 *
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to pause the script until the WebElement is found
	 *
	 * @param locator
	 * @param time
	 */
	public void putWaitToElement(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * This method is used to fetch the title of a web page after wait
	 *
	 * @param text
	 * @param time
	 */
	public void putWaitToTitle(String text, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.titleContains(text));
	}

	/**
	 * This method is used to click on a WebElement
	 *
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to fetch the text of a particular element
	 *
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {
		String s = null;
		try {
			WebElement element = getElement(locator);
			s = element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

}
