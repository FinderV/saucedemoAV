package org.tms.page;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InventoryPage extends Page {

  @FindBy(xpath = "//span[@class='title']")
  private WebElement nameOfMainPageSection;

  @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
  private List<WebElement> AddToCartButton;

  @FindBy(xpath = "//a[@class='shopping_cart_link']")
  private WebElement indicatorOfCart;

  @FindBy(xpath = "//button[contains(@id,'remove')]")
  private List<WebElement> removeItemFromCartButton;

  @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
  private WebElement reactMenuButton;

  @FindBy (xpath = "//div[@class='bm-menu-wrap']")
  private WebElement reactMenu;

  @FindBy (xpath = "//nav[@class='bm-item-list']")
  private WebElement reactMenuList;

  @FindBy (xpath = "//button[@id='react-burger-cross-btn']")
  private WebElement crossButton;

  @FindBy (xpath = "//div[@class='inventory_item_price']")
  private List<WebElement> itemPrice;

  @FindBy (xpath = "//select[@data-test='product_sort_container']")
  private WebElement filterSelect;


  public void clickAddToCartButtonByIndex(int index) {
    AddToCartButton.get(index).click();
  }

  public String getTextOfNumberThingsInCart() {
    return indicatorOfCart.getAttribute("innerText");
  }

  public void clickRemoveItemFromCartButtonByIndex(int index) {
    removeItemFromCartButton.get(index).click();
  }

  public void clickReactMenuButton() {
    reactMenuButton.click();
  }

  public String getAttributeReactMenu () {
    return reactMenu.getAttribute("ariaHidden");
  }

  public String getTextReactMenuList () {
    return reactMenuList.getAttribute("outerText");
  }

  public void clickCrossButtonReactMenu () {
    crossButton.click();
  }

  public List<WebElement> getItemPriceElements() {
    return itemPrice;
  }

  public String getTextOfNameOfMainPageSection() {
    return nameOfMainPageSection.getText();
  }

  public WebElement getFilterSelect() {
    return filterSelect;
  }
}
