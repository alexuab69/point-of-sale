package pos;

public class ComputePaymentInCashRandom extends ComputePaymentInCash {
    @Override
    public BagOfCash ComputePayment(BagOfCash payment, double totalPrice) {
        double aux = totalPrice;
        BagOfCash change = new BagOfCash();
        double[] denominations = {50.0,20.0,10.0,5.0,2.0,1.0,0.5,0.2,0.1,0.05,0.02,0.01};

        return change;
    }
}