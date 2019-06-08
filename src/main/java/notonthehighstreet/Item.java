package notonthehighstreet;

import java.util.Objects;

public class Item {

  private String productCode;

  private String name;

  private double price;

  private String currency;

  public Item(String productCode) {
    this.productCode = productCode;
  }

  public Item(String productCode, String name, double price, String currency) {
    this(productCode);
    this.name = name;
    this.price = price;
    this.currency = currency;
  }

  public String getProductCode() {
    return productCode;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return productCode.equals(item.productCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCode);
  }

  @Override
  public String toString() {
    return "Item{" +
        "productCode='" + productCode + '\'' +
        ", name='" + name + '\'' +
        ", price=" + currency + price + '}';
  }
}
