package Com.Test.Shanthilal.test.steps;

import Com.Test.Shanthilal.test.pages.pages.PersonaInformationPage;
import Com.Test.Shanthilal.test.pages.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditPersonalInformationSteps {

  private PersonaInformationPage page;
  private MainPage mainPage;
  public EditPersonalInformationSteps(PersonaInformationPage page, MainPage mainPage) {
    this.page = page;
    this.mainPage = mainPage;
  }

  @Given("I click on the My Personal info link")
  public void i_click_on_the_my_personal_info_link() {
    mainPage.click(mainPage.personalInformation);
    page.navigateHere();
    
  }

  @Given("I change first name to {string}")
  public void i_change_first_name_to(String firstName) {
    page.firstName.clear();
    page.firstName.sendKeys(firstName);
    
  }

  @Given("I enter current password as {string}")
  public void i_enter_current_password_as(String currentPassword) {
    page.currentPassword.sendKeys(currentPassword);
    
  }

  @When("I click on Save button")
  public void i_click_on_save_button() {
    page.click(page.saveButton);
    
  }

  @Then("I can see {string}")
  public void i_can_see(String message) {
    page.assertEquals(page.updateSuccessful.getText().trim(), message);
    
  }

  @Then("I can see that first name is changed to {string}")
  public void i_can_see_that_first_name_is_changed_to(String firstName) {
    page.assertEquals(page.firstName.getAttribute("value").trim(), firstName);
    
  }
}