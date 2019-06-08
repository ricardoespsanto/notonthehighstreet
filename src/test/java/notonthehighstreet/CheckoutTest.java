package notonthehighstreet;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

  private Checkout checkout;

  @Before
  public void setUp() {
    PromotionalRules promotionalRules = new PromotionalRules();
    this.checkout = new Checkout(promotionalRules);

    Item travelCardHolder = new Item("001");
    Predicate<Basket> moreThanOneTravelCardHolder = basket -> basket
        .getItems().getOrDefault(travelCardHolder, 0) > 1;

    Function<Basket, Double> totalDiscountForTravelCardHolders = basket -> {
      Integer quantityOfTravelCardHolders = basket
          .getItems()
          .getOrDefault(travelCardHolder, 0);
      double discountPerTravelCardHolder = 0.75;
      return quantityOfTravelCardHolders * discountPerTravelCardHolder;
    };

    promotionalRules.addPromotionalRule(
        new Rule("More than one travel card holder -> price = £8.50", moreThanOneTravelCardHolder,
            totalDiscountForTravelCardHolders));

    Predicate<Basket> totalAbove60 = basket -> basket.getTotalAfterDiscounts() > 60;
    Function<Basket, Double> tenPerCentDiscount = Basket -> Basket.getTotalAfterDiscounts() * 0.1;
    promotionalRules
        .addPromotionalRule(new Rule("10% if total > 60", totalAbove60, tenPerCentDiscount));
  }

  @Test
  public void percentageDiscountApplied() {
    checkout.scan("001");
    checkout.scan("002");
    checkout.scan("003");
    Double actualTotal = checkout.total();
    Double expectedTotal = 66.78;
    assertEquals(expectedTotal, actualTotal);
  }

  @Test
  public void multipleTravelCardHoldersDiscountApplied() {
    checkout.scan("001");
    checkout.scan("003");
    checkout.scan("001");
    Double expectedTotal = 36.95;
    Double actualTotal = checkout.total();
    assertEquals(expectedTotal, actualTotal);
  }

  @Test
  public void multipleTravelCardHoldersAndPercentageDiscountApplied() {
    checkout.scan("001");
    checkout.scan("002");
    checkout.scan("001");
    checkout.scan("003");
    Double expectedTotal = 73.76;
    Double actualTotal = checkout.total();
    assertEquals(expectedTotal, actualTotal);
  }

  @Test
  public void multipleNonTravelCardHoldersWillNotReceiveDiscount() {
    checkout.scan("003");
    checkout.scan("003");
    Double expectedTotal = 39.90;
    Double actualTotal = checkout.total();
    assertEquals(expectedTotal, actualTotal);
  }

  @Test
  public void emptyBasketWillBeFree() {
    Double expectedTotal = 0d;
    Double actualTotal = checkout.total();
    assertEquals(expectedTotal, actualTotal);
  }

}
