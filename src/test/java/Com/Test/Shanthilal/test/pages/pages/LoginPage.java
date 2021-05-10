package Com.Test.Shanthilal.test.pages.pages;

import Com.Test.Shanthilal.setup.Config;
import Com.Test.Shanthilal.test.pages.base.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends PageObjectBase {

  /**
   * ALREADY REGISTERED
   **/
  //VIEW//
  @FindBy(how = How.XPATH, using = "//form[@id='login_form']")
  public WebElement registeredPane;

  //MESSAGES//
  @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
  public WebElement registeredLoginError;

  //BUTTONS & INPUTS & DROPDOWN//
  @FindBy(how = How.XPATH, using = "//a[@class='login']")
  public WebElement signIn;

  @FindBy(how = How.XPATH, using = "//input[@id='email']")
  public WebElement registeredEmailInput;

  @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
  public WebElement registeredPasswordInput;

  @FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']")
  public WebElement registeredSignInButton;

  @Override
  public void trait() {
    assertDisplayed(registeredPane, 5);
  }

  @Override
  public void navigateHere() {
    click(signIn);
    trait();
  }
}
