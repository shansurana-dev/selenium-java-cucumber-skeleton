package Com.Test.Shanthilal.test.pages.pages;

import Com.Test.Shanthilal.test.pages.base.PageObjectBase;
import Com.Test.Shanthilal.setup.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageObjectBase {

  @FindBy(css = "img.logo")
  private WebElement logo;

  @FindBy(xpath = "//a[@title='Manage my personal information']")
  public WebElement personalInformation;

  @FindBy(css = "div.video-player-container.player-container")
  private WebElement neatGif;

  @FindBy(css = "button.search-button")
  private WebElement search;

  @FindBy(className = "grid-gfy-item")
  private List<WebElement> gifs;

  @Override
  public void trait() {
    assertDisplayed(logo, 10);
  }

  @Override
  public void navigateHere() {
    loadEnv(Config.getEnv());
    //trait();
  }

  public void isPageReady() {
    trait();
  }

  public void openNeatGif() {
    waitForNotStale(gifs.get(0), 5);
    click(gifs.get(0));

    /**
     * DO NOT USE THIS. It is only meant to show the gif that we found and clicked on as a visual
     * since it is so fast :)
     */
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
