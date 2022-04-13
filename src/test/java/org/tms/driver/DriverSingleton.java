package org.tms.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

  private static  ThreadLocal<DriverSingleton> instance = new ThreadLocal<>();

  private WebDriver driver;

  private DriverSingleton() {
    driver = WebDriverFactory.getWebDriver();
  }

  public static synchronized DriverSingleton getInstance() {
    if (instance.get() == null) {
      instance.set(new DriverSingleton());
    }
    return instance.get();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void closeDriver() {
    try {
      driver.quit();
      driver = null;
    } finally {
      instance.remove();
    }
  }
}
