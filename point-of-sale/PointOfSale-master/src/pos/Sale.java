package pos;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sale {
  boolean isPaid = false;
  private int id;
  private ArrayList<SaleLineItem> saleLineItems = new ArrayList<>();
  private LocalDateTime dateTime = LocalDateTime.now();
  private PaymentInCash payment_cash;
  private PaymentByCreditCard payment_credit;

  public Sale(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void addLineItem(ProductSpecification productSpecification, int quantity) {
    for (SaleLineItem item : saleLineItems) {
      if (item.productSpecification == productSpecification) { // same object
        item.incrementQuantity(quantity);
        return;
      }
    }
    saleLineItems.add(new SaleLineItem(productSpecification, quantity));
  }

  private double total() {
    double total = 0.;
    for (SaleLineItem saleLineItem : saleLineItems) {
      total += saleLineItem.subtotal();
    }
    return total;
  }

  public void printReceipt() {
    System.out.println("Sale " + id);
    System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyy hh:mm").format(dateTime));
    for (SaleLineItem saleLineItem : saleLineItems) {
      saleLineItem.print();
    }
    System.out.printf("Total %.2f\n", total());
  }

  public void badPrintReceipt() {
    System.out.println("Sale " + id);
    System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyy hh:mm").format(dateTime));
    double total = 0.;
    for (SaleLineItem saleLineItem : saleLineItems) {
      String prodName = saleLineItem.productSpecification.getName();
      int quantity = saleLineItem.quantity; //getQuantity();
      double price = saleLineItem.productSpecification.getPrice();
      double subtotal = quantity * price;
      System.out.printf("%s %d x %.2f = %.2f\n", prodName, quantity, price, subtotal);
      total += subtotal;
    }
    System.out.printf("Total %.2f\n", total);
  }

  //credit card
  public void payCreditCard(double amount) {
    assert !isPaid : "sale " + id + " has already been paid";
    payment_credit = new PaymentByCreditCard(amount);
    isPaid = true;
  }

  public void payCash(BagOfCash amount) {
    assert !isPaid : "sale " + id + " has already been paid";
    payment_cash = new PaymentInCash(amount);
    isPaid = true;
  }

  public void printChange() {
    assert payment_cash != null : "No payment for sale " + id;
    System.out.print("\nAmount paid : ");
    payment_cash.getAmount().displayBag();
    System.out.print("\nChange : ");
    payment_cash.change(total()).displayBag();
  }

  public boolean isPaid() {
    return isPaid;
  }
}
