package pos;

public class PaymentByCreditCard {
    Double amount; // Euros

    public PaymentByCreditCard(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
