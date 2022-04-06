package org.tms.test;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.service.InventoryPageService;

public class InventoryPageFilterTest {

  private InventoryPageService inventoryPageService = new InventoryPageService();

  @Test
  public void sortByPriceTest() {
    inventoryPageService.login();
    List<Double> expectedList = inventoryPageService.getItemPrice();
    Collections.sort(expectedList);
    inventoryPageService.sortByPrice();
    List<Double> actualList = inventoryPageService.getItemPrice();
    Assert.assertEquals(actualList, expectedList, "Sorting didn't work!");
  }
}
