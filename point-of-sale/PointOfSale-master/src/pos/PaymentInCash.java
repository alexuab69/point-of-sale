package pos;

public class PaymentInCash {
  BagOfCash amount; // Euros

  public PaymentInCash(BagOfCash amount) {
    this.amount = amount;
  }

  public BagOfCash change(double totalSale) {
    ComputePaymentInCash compute = new ComputePaymentInCashGreedy();
    BagOfCash change = compute.ComputePayment(amount,totalSale);
    return change;
  }

  public BagOfCash getAmount() {
    return amount;
  }
}
