package org.tms.service;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import org.tms.page.InventoryPage;

public class InventoryPageService {

  private InventoryPage inventoryPage;
  private LoginPageService loginPageService = new LoginPageService();

  public InventoryPageService login() {
    inventoryPage = loginPageService.login();
    return this;
  }

  public InventoryPageService addToCartItem(int itemIndex) {
    inventoryPage.clickAddToCartButtonByIndex(itemIndex);
    return this;
  }

  public InventoryPageService removeItemFromCart(int itemIndex) {
    inventoryPage.clickRemoveItemFromCartButtonByIndex(itemIndex);
    return this;
  }

  public String getNumberOfItemsInCart() {
    return inventoryPage.getTextOfNumberThingsInCart();
  }

  public List<Double> getItemPrice() {
    List<Double> priceList = new ArrayList<>();
    for (int i = 0; i < inventoryPage.getItemPriceElements().size(); i++) {
      priceList.add(Double.parseDouble(inventoryPage.getItemPriceElements().get(i).getText().replaceAll("[^0-9.]", "")));
    }
   return priceList;
  }

  public void sortByPrice() {
    Select select = new Select(inventoryPage.getFilterSelect());
    select.selectByVisibleText("Price (low to high)");
  }

}
