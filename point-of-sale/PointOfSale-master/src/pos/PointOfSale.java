package pos;

import java.util.ArrayList;


public class PointOfSale {
  private ProductCatalog productCatalog;
  private ArrayList<Sale> sales;
  private int idLastSale = 0;
  private final String FILE_NAME = "src/pos/catalog.txt";
  private BagOfCash cashBox;

  public PointOfSale() {
    productCatalog = new ProductCatalog(FILE_NAME);
    sales = new ArrayList<>();
    cashBox.addCash(50.0,10000);
    cashBox.addCash(20.0,10000);
    cashBox.addCash(10.0,10000);
    cashBox.addCash(5.0,10000);
    cashBox.addCash(2.0,10000);
    cashBox.addCash(1.0,10000);
    cashBox.addCash(0.5,10000);
    cashBox.addCash(0.2,10000);
    cashBox.addCash(0.1,10000);
    cashBox.addCash(0.05,10000);
    cashBox.addCash(0.02,10000);
    cashBox.addCash(0.01,10000);
  }

  public int makeNewSale() {
    idLastSale++;
    Sale newSale = new Sale(idLastSale);
    sales.add(newSale);
    return idLastSale;
  }

  public void addLineItemToSale(int idSale, String productName, int quantity) {
    ProductSpecification productSpecification = productCatalog.searchByName(productName);
    Sale sale = searchSaleById(idSale);
    sale.addLineItem(productSpecification, quantity);
  }

  private Sale searchSaleById(int id) {
    for (Sale s : sales) {
      if (s.getId() == id) {
        return s;
      }
    }
    return null;
  }

  public void printReceiptOfSale(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printReceipt();
  }

  public void payOneSale(int saleId, BagOfCash amount) {
    Sale sale = searchSaleById(saleId);
    sale.payCash(amount);
    //cashBox.addCash(amount);
  }

  public void printChangeOfSale(int saleId) {
    Sale sale = searchSaleById(saleId);
    sale.printChange();
  }

  public boolean isSalePaid(int id) {
    return searchSaleById(id).isPaid();
  }

  // this is for the user interface
  public ArrayList<String> getProductNames() {
    return productCatalog.getProductNames();
  }
}

