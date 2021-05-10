package Com.Test.Shanthilal.test.steps;

import Com.Test.Shanthilal.test.pages.pages.LoginPage;
import Com.Test.Shanthilal.test.pages.pages.AccountPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Collections;

public class LoginPageSteps {

  private LoginPage page;
  private AccountPage accountPage;
  public LoginPageSteps(LoginPage page, AccountPage accountPage) {
    this.page = page;
    this.accountPage = accountPage;
    
  }

  @When("I log in as customer {string} using {string} password")
  public void i_log_in_as_customer_using_password(String email, String password) {
    page.click(page.signIn);
    page.navigateHere();
    page.registeredEmailInput.sendKeys(email);
    page.registeredPasswordInput.sendKeys(password);
    page.click(page.registeredSignInButton);
    
  }

  @Then("I can see welcome message on the landing page")
  public void i_can_see_welcome_message_on_the_landing_page() {
    accountPage.navigateHere();
    accountPage.assertTextFound(Collections.singletonList(accountPage.myAccountDetailsDashboard),"Welcome to your account. Here you can manage all of your personal information and orders.");
    
  }
}