/*
 * (c) Copyright Reserved EVRYTHNG Limited 2018. All rights reserved.
 * Use of this material is subject to license.
 * Copying and unauthorised use of this material strictly prohibited.
 */
package notonthehighstreet;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {

  private Checkout checkout;

  @Before
  public void setUp() {
    this.checkout = new Checkout(new PromotionalRules());
  }

  @Test
  public void scanningANullItemWillThrowException() {
    checkout.scan(null);
  }

}
