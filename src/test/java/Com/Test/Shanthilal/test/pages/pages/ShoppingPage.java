package Com.Test.Shanthilal.test.pages.pages;

import Com.Test.Shanthilal.test.pages.base.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;

public class ShoppingPage extends PageObjectBase {

  /**
   * ALREADY REGISTERED
   **/
  //VIEW//
  @FindBy(how = How.XPATH, using = "//span[@class='category-name']")
  public WebElement tShirtPane;

  //BUTTONS & INPUTS & DROPDOWN//
  @FindBy(how = How.XPATH, using = "//a[@title='T-shirts']")
  public WebElement tab;

  public void selectProduct(String productName){
    driver.findElement(By.xpath(
            ("//div[@id='center_column']//a[@class='product-name' and contains(text(),'" + productName + "')]"))).click();
  }

  @Override
  public void trait() {
    assertDisplayed(tShirtPane, 5);
  }

  @Override
  public void navigateHere() {
    click(tab);
    trait();
  }
}
