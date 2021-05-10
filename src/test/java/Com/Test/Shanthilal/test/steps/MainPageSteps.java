package Com.Test.Shanthilal.test.steps;

import Com.Test.Shanthilal.test.pages.pages.MainPage;
import io.cucumber.java.en.Given;

public class MainPageSteps {

  private MainPage page;

  public MainPageSteps(MainPage page) {
    this.page = page;
  }

  @Given("I can navigate to the website")
  public void i_can_navigate_to_the_website() {
    page.navigateHere();
    
  }

  @Given("I can see the website homepage")
  public void i_can_see_the_website_homepage() {
    page.isPageReady();
    
  }
}