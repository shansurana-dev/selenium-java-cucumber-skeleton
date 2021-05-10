package Com.Test.Shanthilal.test.pages.pages;

import Com.Test.Shanthilal.test.pages.base.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonaInformationPage extends PageObjectBase {

  /**
   * ALREADY REGISTERED
   **/
  @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
  public WebElement updateSuccessful;

  //BUTTONS & INPUTS & DROPDOWN//
  @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
  public WebElement firstName;

  @FindBy(how = How.XPATH, using = "//input[@name='old_passwd']")
  public WebElement currentPassword;

  @FindBy(how = How.XPATH, using = "//button[@name='submitIdentity']")
  public WebElement saveButton;

  @Override
  public void trait() {
    assertDisplayed(firstName, 10);
  }

  @Override
  public void navigateHere() {
   trait();
  }
}
