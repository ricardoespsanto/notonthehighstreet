package notonthehighstreet;

import java.util.ArrayList;
import java.util.Collection;

public class PromotionalRules {

  private Collection<Rule> ruleCollection;

  public PromotionalRules() {
    this.ruleCollection = new ArrayList<>();
  }

  public void addPromotionalRule(Rule newRule) {
    ruleCollection.add(newRule);
  }

  public void applyPromotions(Basket basket) {
    ruleCollection.forEach(rule -> rule.applyRule(basket));
  }

}
