package pos;

public class PaymentInCash {
  BagOfCash amount; // Euros

  public PaymentInCash(BagOfCash amount) {
    this.amount = amount;
  }

  public BagOfCash change(double totalSale) {
    ComputePaymentInCashGreedy compute;
    BagOfCash change = compute.ComputePayment(amount,totalSale);
    return change;
  }

  public BagOfCash getAmount() {
    return amount;
  }
}
