package org.tms.test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.service.InventoryPageService;

public class InventoryPageFilterTest extends BaseTest {

  private InventoryPageService inventoryPageService;

  @BeforeClass
  public void setUp() {
    inventoryPageService = new InventoryPageService();
  }


  @Test(description = "Sorting by price")
  @Description("Sorting by price on Inventory Page")
  @Link("https://github.com/Alexandr-Sirotkin")
  @Issue("Alexandr-Sirotkin")
  @TmsLink("Alexandr-Sirotkin")
  public void sortByPriceTest() {
    inventoryPageService.login();
    List<Double> expectedList = inventoryPageService.getItemPrice();
    Collections.sort(expectedList);
    inventoryPageService.sortByPrice();
    List<Double> actualList = inventoryPageService.getItemPrice();
    Assert.assertEquals(actualList, expectedList, "Sorting didn't work!");
  }
}
