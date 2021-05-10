package Com.Test.Shanthilal.test.pages.pages;

import Com.Test.Shanthilal.test.pages.base.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OrderPage extends PageObjectBase {

  /**
   * ALREADY REGISTERED
   **/
  //VIEW//
  @FindBy(xpath = "//table[@id='order-list']/tbody/tr/td[1]/a")
  public List<WebElement> orderReferences;

  @Override
  public void trait() {
    assertAllDisplayed(orderReferences);
  }

  @Override
  public void navigateHere() {
   trait();
  }
}
