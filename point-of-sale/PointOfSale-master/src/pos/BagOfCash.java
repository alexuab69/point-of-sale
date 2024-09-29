package pos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class BagOfCash {
    private Map<Double, Integer> cashCombination;
    public BagOfCash() {
        cashCombination = new HashMap<>();
        initializeBagOfCash();
    }

    private void initializeBagOfCash(){
        cashCombination.put(50.0,0);
        cashCombination.put(20.0,0);
        cashCombination.put(10.0,0);
        cashCombination.put(5.0,0);
        cashCombination.put(2.0,0);
        cashCombination.put(1.0,0);
        cashCombination.put(0.50,0);
        cashCombination.put(0.20,0);
        cashCombination.put(0.10,0);
        cashCombination.put(0.05,0);
        cashCombination.put(0.02,0);
        cashCombination.put(0.01,0);
    }
    public void addCash(double denomination, int quantity){
        assert cashCombination.containsKey(denomination):"Invalid denomination";
            cashCombination.put(denomination, cashCombination.get(denomination)+quantity);
    }
    public boolean removeCash(double denomination, int quantity){
        assert cashCombination.containsKey(denomination):"Invalid denomination";
        int currentQuantity = cashCombination.get(denomination);
        if (currentQuantity >= quantity) {
            cashCombination.put(denomination, currentQuantity - quantity);
            return true;
        } else {
            System.out.println("Not enough cash to remove");
            return false;
        }
    }
    public void displayBag() {
        System.out.println("Contents of the Bag of Cash:");
        for (Map.Entry<Double, Integer> entry : cashCombination.entrySet()) {
            System.out.printf("Denomination: %.2f, Quantity: %d%n", entry.getKey(), entry.getValue());
        }
    }
    public int getDenomination(double denomination){
        assert cashCombination.containsKey(denomination):"Invalid denomination";
        return cashCombination.get(denomination);
    }//hola
}
