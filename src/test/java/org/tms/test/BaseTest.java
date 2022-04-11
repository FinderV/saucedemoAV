package org.tms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.tms.driver.DriverSingleton;

public class BaseTest {

  protected WebDriver driver;

  @BeforeClass
  public void startBrowser() {
    driver = DriverSingleton.getDriver();
  }

  @AfterClass(alwaysRun = true)
  public void stopBrowser() {
    DriverSingleton.closeDriver();
  }

}
