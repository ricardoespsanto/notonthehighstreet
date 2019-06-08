package notonthehighstreet;

import java.util.HashMap;
import java.util.Map;

public class Basket {

  private ItemRepository itemRepository;

  private Map<Item, Integer> itemsInBasket;

  private Double totalAfterDiscounts;

  public Basket() {
    this.itemRepository = new ItemRepository();
    this.itemsInBasket = new HashMap<>();
  }

  public double getTotalBeforeDiscounts() {
    return itemsInBasket.keySet().stream()
        .mapToDouble(item -> item.getPrice() * itemsInBasket.getOrDefault(item, 1)).sum();
  }

  public void addItemToBasket(String productCode) {
    itemRepository
        .getItemByProductCode(productCode)
        .ifPresent(
            item -> itemsInBasket.merge(item, itemsInBasket.getOrDefault(item, 1), Integer::sum));
  }

  public void applyDiscount(double discount) {
    lazyInitialisationOfTotalAfterDiscount();
    this.totalAfterDiscounts -= discount;
  }

  private void lazyInitialisationOfTotalAfterDiscount() {
    if (this.totalAfterDiscounts == null) {
      this.totalAfterDiscounts = getTotalBeforeDiscounts();
    }
  }

  public double getTotalAfterDiscounts() {
    lazyInitialisationOfTotalAfterDiscount();
    return totalAfterDiscounts;
  }

  public Map<Item, Integer> getItems() {
    return itemsInBasket;
  }

}
