package org.tms.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.driver.DriverSingleton;

public abstract class Page {

  protected WebDriver driver = DriverSingleton.getDriver();
  private final static int WAIT_TIMEOUT_SECONDS = 10;

  protected Page() {
    PageFactory.initElements(driver, this);
  }

  protected WebElement waitVisibilityOf(WebElement element) {
    return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(element));
  }

  protected WebElement waitElementToBeClickable(WebElement element) {
    return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.elementToBeClickable(element));
  }

}
