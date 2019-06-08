package notonthehighstreet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class ItemRepository {

  private Collection<Item> itemCollection;

  public ItemRepository() {
    int itemCollectionInitialSize = 3;
    this.itemCollection = new ArrayList<>(itemCollectionInitialSize);
    this.itemCollection.add(new Item("001", "Travel Card Holder", 9.25, "£"));
    this.itemCollection.add(new Item("002", "Personalised cufflinks", 45.00, "£"));
    this.itemCollection.add(new Item("003", "Kids T-shirt", 19.95, "£"));
  }

  public Optional<Item> getItemByProductCode(String productCode) {
    return itemCollection.stream()
        .filter(item -> item.getProductCode().equalsIgnoreCase(productCode)).findFirst();
  }

}
