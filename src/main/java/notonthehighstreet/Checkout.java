package notonthehighstreet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Checkout {

  private PromotionalRules promotionalRules;

  private Basket basket;

  public Checkout(PromotionalRules promotionalRules) {
    this.promotionalRules = promotionalRules;
    this.basket = new Basket();
  }

  void scan(String item) {
    basket.addItemToBasket(item);
  }

  double total() {
    promotionalRules.applyPromotions(basket);
    return BigDecimal.valueOf(basket.getTotalAfterDiscounts()).setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }

}
