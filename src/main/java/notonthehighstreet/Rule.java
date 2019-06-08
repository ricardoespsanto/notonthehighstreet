package notonthehighstreet;

import java.util.function.Function;
import java.util.function.Predicate;

public class Rule {

  private Predicate<Basket> condition;

  private Function<Basket, Double> effect;

  private String ruleDescription;

  public Rule(String ruleDescription, Predicate<Basket> condition,
      Function<Basket, Double> effect) {
    this.condition = condition;
    this.effect = effect;
    this.ruleDescription = ruleDescription;
  }

  public void applyRule(Basket basket) {
    if (condition.test(basket)) {
      Double discount = effect.apply(basket);
      basket.applyDiscount(discount);
    }
  }

  @Override
  public String toString() {
    return "Rule -> " + ruleDescription;
  }
}
