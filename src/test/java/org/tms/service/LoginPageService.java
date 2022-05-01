package org.tms.service;

import io.qameta.allure.Step;
import org.tms.model.User;
import org.tms.page.InventoryPage;
import org.tms.page.LoginPage;

public class LoginPageService {

  protected static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

  protected LoginPage loginPage = new LoginPage();
  protected User user = new User();

  @Step("Authorization on the site under the default user")
  public InventoryPage login() {
    loginPage.openPage(LOGIN_PAGE_URL)
             .fillInUsername(user.getName())
             .fillInPassword(user.getPassword())
             .clickLoginButton();
    return new InventoryPage();
  }

}
