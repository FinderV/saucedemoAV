package org.tms.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

  @FindBy(xpath = "//input[@id='user-name']")
  private WebElement username;

  @FindBy(xpath = "//input[@id='password']")
  private WebElement password;

  @FindBy(xpath = "//input[@id='login-button']")
  private WebElement loginButton;

  @Step("Opening saucedemo.com")
  public LoginPage openPage(String url) {
    driver.get(url);
    return this;
  }

  @Step("Entering the user name {userName}")
  public LoginPage fillInUsername(String userName) {
    waitVisibilityOf(username).sendKeys(userName);
    return this;
  }

  @Step("Entering the user's password {keyPassword}")
  public LoginPage fillInPassword(String keyPassword) {
    waitVisibilityOf(password).clear();
    password.sendKeys(keyPassword);
    return this;
  }

  @Step("Clicking the login button")
  public void clickLoginButton() {
    waitElementToBeClickable(loginButton).click();
  }

}
