package Com.Test.Shanthilal.test.steps;

import Com.Test.Shanthilal.test.pages.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Com.Test.Shanthilal.utilities.Tools.logger;

public class ShoppingSteps {

  private ShoppingPage page;
  private AccountPage accountPage;
  private ProductPage productPage;
  private ShoppingCartPage shoppingCartPage;
  private OrderPage orderPage;
  String cartProductQuantity, cartProductSize, cartProductColor, cartProductName, cartPaymentType, orderReference;
  public ShoppingSteps(ShoppingPage page, AccountPage accountPage, ProductPage productPage, ShoppingCartPage shoppingCartPage, OrderPage orderPage) {
    this.page = page;
    this.accountPage = accountPage;
    this.productPage = productPage;
    this.shoppingCartPage = shoppingCartPage;
    this.orderPage = orderPage;
  }

  @Given("I am on the account landing page")
  public void i_am_on_the_account_landing_page() {
    accountPage.navigateHere();
    accountPage.assertTextFound(Collections.singletonList(accountPage.myAccountDetailsDashboard), "Welcome to your account. Here you can manage all of your personal information and orders.");
  }

  @Given("I click on the {string} Tab")
  public void i_click_on_the_tab(String tabName) {
    page.navigateHere();
    String category = page.tShirtPane.getText().trim();
    page.assertEquals(tabName, category);
  }

  @Given("I click on {string} product")
  public void i_click_on_product(String productName) {
    cartProductName = productName;
    page.selectProduct(productName);
  }

  @Given("I choose following details in my order")
  public void i_choose_following_details_in_my_order(DataTable dataTable) {
    //INITIALIZE//
    List<List<String>> data = dataTable.asLists();
    final String productQuantity = data.get(1).get(0);
    final String productSize = data.get(1).get(1);
    final String productColor = data.get(1).get(2);
    cartProductQuantity = data.get(1).get(0);
    cartProductSize = data.get(1).get(1);
    cartProductColor = data.get(1).get(2);
    productPage.quantityInput.clear();
    //ACTION//
    productPage.quantityInput.sendKeys(productQuantity);
    productPage.sizeDropdown.click();
    switch (productColor.toLowerCase()) {
      case "orange":
        productPage.orangeColorButton.click();
        break;
      case "blue":
        productPage.blueColorButton.click();
        break;
    }
    //ASSERTIONS//
    productPage.assertEquals(productPage.readSizeDropdown.getText().toLowerCase(),
            productSize.toLowerCase());
    productPage.assertEquals(productPage.readChosenColor.getAttribute("title").toLowerCase(),
            productColor.toLowerCase());
  }

  @When("I click on Add To Cart button")
  public void i_click_on_add_to_cart_button() {
    productPage.addToCartButton.click();
  }

  @When("I can see modal confirming product being added to the cart")
  public void i_can_see_modal_confirming_product_being_added_to_the_cart() {
    //ASSERTIONS//
    productPage.assertDisplayed(productPage.popupPaneProductDetails, 5);
    productPage.assertDisplayed(productPage.popupPaneAddedSuccessfully, 5);
    //ASSERTIONS - POPUP LEFT SIDE//
    productPage.assertEquals(productPage.popupPaneCartProductName.getText().trim().toLowerCase(), cartProductName.toLowerCase());
    productPage.assertEquals(productPage.popupPaneCartProductQuantity.getText().trim(), cartProductQuantity);
  }

  @When("I click on Proceed To Checkout button on pop up")
  public void i_click_on_proceed_to_checkout_button_on_pop_up() {
    productPage.proceedToCheckoutButton.click();
  }

  @When("I can see {string} form with valid information")
  public void i_can_see_form_with_valid_information(String shoppingCartTab) {
    //INITIALIZE//
    shoppingCartPage.navigateHere();
    final String navigationTopLabelHeaderText = shoppingCartPage.navigationTopLabelHeader.getText();
    final String LABEL_YOUR_SHOPPING_CART = "Your shopping cart";
    final String LABEL_ADDRESSES = "Addresses";
    final String LABEL_SHIPPING = "Shipping";
    final String LABEL_YOUR_PAYMENT_METHOD = "Your payment method";
    final String LABEL_ORDER_CONFIRMATION = "Order confirmation";
    //ASSERTIONS//
    switch (shoppingCartTab.toLowerCase()) {
      case "your shopping cart":
        shoppingCartPage.assertEquals(navigationTopLabelHeaderText.toLowerCase(), LABEL_YOUR_SHOPPING_CART.toLowerCase());
        break;
      case "addresses":
        shoppingCartPage.assertEquals(navigationTopLabelHeaderText.toLowerCase(), LABEL_ADDRESSES.toLowerCase());
        break;
      case "shipping":
        shoppingCartPage.assertEquals(navigationTopLabelHeaderText.toLowerCase(), LABEL_SHIPPING.toLowerCase());
        break;
      case "your payment method":
        shoppingCartPage.assertEquals(navigationTopLabelHeaderText.toLowerCase(), LABEL_YOUR_PAYMENT_METHOD.toLowerCase());
        break;
      case "order confirmation":
        shoppingCartPage.assertEquals(navigationTopLabelHeaderText.toLowerCase(), LABEL_ORDER_CONFIRMATION.toLowerCase());
        shoppingCartPage.assertEquals(shoppingCartPage.orderSuccessful.getText().trim(),"Your order on My Store is complete.");
        String temp = shoppingCartPage.orderConfirmation.getText().trim();
        final String[] subStrings = temp.split("\\s");
        orderReference=subStrings[Arrays.asList(subStrings).indexOf("reference") + 1];
        break;
    }
  }

  @When("I click on Proceed To Checkout button")
  public void i_click_on_proceed_to_checkout_button() {
    shoppingCartPage.proceedToCheckoutButton.click();
  }

  @When("I choose the shipping option as {string}")
  public void i_choose_the_shipping_option_as(String shippingOption) {
    switch (shippingOption.toLowerCase()) {
      case "my carrier":
        if (!shoppingCartPage.myCarrierRadioButton.isSelected()) {
          shoppingCartPage.myCarrierRadioButton.click();
        }
    }
  }

  @When("I select the Terms of Service checkbox")
  public void i_select_the_terms_of_service_checkbox() {
      if (!shoppingCartPage.tosCheckbox.isSelected()) {
        shoppingCartPage.tosCheckbox.click();
      }
  }

  @When("I choose a payment method {string}")
  public void i_choose_a_payment_method(String paymentMethod) {
    cartPaymentType = paymentMethod;
    switch (paymentMethod.toLowerCase()) {
      case "pay by check":
        shoppingCartPage.chequePaymentBox.click();
        break;
      case "pay by bank wire":
        shoppingCartPage.bankWirePaymentBox.click();
        break;
    }
  }

  @When("I click on I Confirm My Order button")
  public void i_click_on_i_confirm_my_order_button() {
      shoppingCartPage.iConfirmMyOrderButton.click();
  }

  @Then("I click on Back To Order button")
  public void i_click_on_back_to_order_button() {
    shoppingCartPage.backToOrders.click();
  }

  @Then("I can see the Order Reference of the order placed")
  public void i_can_see_the_order_reference_of_the_order_placed() {
    boolean matched = false;
    orderPage.navigateHere();
    for (WebElement order : orderPage.orderReferences){
      if(order.getText().trim().equals(orderReference.trim()))
        matched = true;
    }
    logger().traceEntry();
    orderPage.assertEquals(matched,true);
    logger().traceExit();
  }
}