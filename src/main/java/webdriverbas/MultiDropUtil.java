package webdriverbas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiDropUtil {

	WebDriver driver;

	/**
	 * This method is the default constructor of this class
	 *
	 * @param driver
	 */
	public MultiDropUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to click on a single, multiple and all the options
	 * available in a MultiSelect drop down
	 *
	 * @param locator
	 * @param value
	 */
	public void multiSelectDropDown(By locator, String... value) {
		List<WebElement> list = driver.findElements(locator);

		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement element : list) {
				String s = element.getText();

				for (String element2 : value) {
					if (s.equals(element2)) {
						element.click();
					}

				}

			}
		} else {
			try {

				for (WebElement element : list) {
					element.click();
				}
			} catch (Exception e) {
			}
		}

	}

}
