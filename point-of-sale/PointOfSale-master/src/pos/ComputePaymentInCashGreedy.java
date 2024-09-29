package pos;

public class ComputePaymentInCashGreedy extends ComputePaymentInCash {
    @Override
    public BagOfCash ComputePayment(BagOfCash payment, double totalPrice) {
        double aux = totalPrice;
        BagOfCash change = new BagOfCash();
        double[] denominations = {50.0,20.0,10.0,5.0,2.0,1.0,0.5,0.2,0.1,0.05,0.02,0.01};
        for (double denomination : denominations) {
            while(denomination < aux) {
                int quantity = payment.getQuantity(denomination);
                if(quantity > 0) {
                    change.addCash(denomination,1);
                    aux -= denomination;
                    payment.removeCash(denomination,1);
                }

            }

        }
        return change;
    }
}