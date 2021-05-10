package Com.Test.Shanthilal.test.pages.pages;

import Com.Test.Shanthilal.setup.Config;
import Com.Test.Shanthilal.test.pages.base.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends PageObjectBase {

  /**
   * ALREADY REGISTERED
   **/
  //VIEW//
  @FindBy(how = How.XPATH, using = "//p[@class='info-account']")
  public WebElement myAccountDetailsDashboard;

  @Override
  public void trait() {
    assertDisplayed(myAccountDetailsDashboard, 10);
  }

  @Override
  public void navigateHere() {
   trait();
  }
}
