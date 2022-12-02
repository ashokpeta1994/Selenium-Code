package com.waitutils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitUtil {

	WebDriver driver;

	public WaitUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to define the Fluent Wait of a particular WebElement
	 *
	 * @param locator
	 */
	public WebElement waitFluent(WebElement element, final By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		element = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver t) {
				return driver.findElement(locator);
			}

		});
		return element;
	}

	public void customWait(By locator, int time, int pollTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(pollTime)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
