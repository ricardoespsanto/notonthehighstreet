/*
 * (c) Copyright Reserved EVRYTHNG Limited 2018. All rights reserved.
 * Use of this material is subject to license.
 * Copying and unauthorised use of this material strictly prohibited.
 */
package notonthehighstreet;

public class Checkout {

  private PromotionalRules promotionalRules;

  public Checkout(PromotionalRules promotionalRules) {
    this.promotionalRules = promotionalRules;
  }

  void scan(Item item) {
  }

  Double total() {
    return 0d;
  }

}
