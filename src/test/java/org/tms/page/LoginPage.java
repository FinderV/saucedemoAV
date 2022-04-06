package org.tms.page;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.utils.Waiter;

public class LoginPage extends Page {

  @FindBy(xpath = "//input[@id='user-name']")
  private WebElement username;

  @FindBy(xpath = "//input[@id='password']")
  private WebElement password;

  @FindBy(xpath = "//input[@id='login-button']")
  private WebElement loginButton;

  public LoginPage openPage(String url) {
    driver.get(url);
    return this;
  }

  public LoginPage fillInUsername(String userName) {
    waitVisibilityOf(username).sendKeys(userName);
    return this;
  }

  public LoginPage fillInPassword(String keyPassword) {
    waitVisibilityOf(password).clear();
    password.sendKeys(keyPassword);
    return this;
  }

  public void clickLoginButton() {
    waitElementToBeClickable(loginButton).click();
  }

}
