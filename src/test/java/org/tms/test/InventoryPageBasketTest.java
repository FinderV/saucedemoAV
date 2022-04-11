package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.service.InventoryPageService;

public class InventoryPageBasketTest extends BaseTest {

  private static int firstItem = 0;
  private InventoryPageService inventoryPageService;

  @BeforeClass
  public void setUp() {
    inventoryPageService = new InventoryPageService();
  }

  @Test
  public void addToCartTest () {
    inventoryPageService.login();
    String initialNumberOfItemsInCart = inventoryPageService.getNumberOfItemsInCart();
    String expectedNumberOfItemsInCart = getExpectedNumberOfItemsInCartAfterAdding(initialNumberOfItemsInCart);
    inventoryPageService.addToCartItem(firstItem);
    String actualNumberOfItemsInCart = inventoryPageService.getNumberOfItemsInCart();
    Assert.assertEquals (actualNumberOfItemsInCart, expectedNumberOfItemsInCart, "Number of added things doesn't match!");
  }

  @Test(dependsOnMethods = "addToCartTest")
  public void removeFromCartTest () {
    String initialNumberOfItemsInCart = inventoryPageService.getNumberOfItemsInCart();
    String expectedNumberOfItemsInCart = getExpectedNumberOfItemsInCartAfterRemoval(initialNumberOfItemsInCart);
    inventoryPageService.removeItemFromCart(firstItem);
    String actualNumberOfItemsInCart = getActualNumberOfItemsInCartAfterRemoval(inventoryPageService.getNumberOfItemsInCart());
    Assert.assertEquals (actualNumberOfItemsInCart, expectedNumberOfItemsInCart, "Number of added things doesn't match!");
  }

  private String getExpectedNumberOfItemsInCartAfterAdding(String numberOfItemsInCart) {
    if (numberOfItemsInCart.equals("")) {
      return "1";
    } else {
      return Integer.toString(Integer.parseInt(numberOfItemsInCart) + 1);
    }
  }

  private String getExpectedNumberOfItemsInCartAfterRemoval(String numberOfItemsInCart) {
      return Integer.toString(Integer.parseInt(numberOfItemsInCart) - 1);
  }

  private String getActualNumberOfItemsInCartAfterRemoval(String numberOfItemsInCart) {
    if (numberOfItemsInCart.equals("")) {
      return "0";
    } else {
      return numberOfItemsInCart;
    }
  }

}
