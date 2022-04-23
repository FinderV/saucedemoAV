package org.tms.test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class LoginPageTest extends BaseTest {

  private LoginPageService loginPageService;

  @BeforeClass
  public void setUp() {
    loginPageService = new LoginPageService();
  }

  @Test(description = "Login to https://www.saucedemo.com/")
  @Description("Login to https://www.saucedemo.com / as standard_user")
  @Link("https://github.com/Alexandr-Sirotkin")
  @Issue("Alexandr-Sirotkin")
  @TmsLink("Alexandr-Sirotkin")
  public void loginTest() {
    InventoryPage inventoryPage = loginPageService.login();
    String actualTextOfInventoryPage = inventoryPage.getTextOfNameOfMainPageSection();
    String expectedPageText = "PRODUCTS";
    Assert.assertEquals(actualTextOfInventoryPage, expectedPageText, "The actual text of the page does not match expected!");
  }

}
