import java.rmi.RemoteException;

public class Product implements ProductInterface {
    // Attributes of product

    private String productcode;
    private String name;
    private String description;
    private double storeprice;
    private double retailprice;
    private double stock;

    Product(String newProductCode, String newName, String newDescription, double newStorePrice, double newRetailPrice,
            double newStock)
            throws RemoteException {
        this.productcode = newProductCode;
        this.name = newName;
        this.description = newDescription;
        this.storeprice = newStorePrice;
        this.retailprice = newRetailPrice;
        this.stock = newStock;

    }

    public String ProductCode() throws RemoteException {
        return this.productcode;
    }

    public String Name() throws RemoteException {
        return this.name;
    }

    public String Description() throws RemoteException {
        return this.description;
    }

    public double StorePrice() throws RemoteException {
        return this.storeprice;
    }

    public double RetailPrice() throws RemoteException {
        return this.retailprice;
    }

    public double Stock() throws RemoteException {
        return this.stock;
    }
    public void setStock(double newStock) throws RemoteException {
        this.stock = newStock;
    }


    

    public void ViewProducts() {
        System.out.println("Product Code: " + productcode);
        System.out.println("Product Name: " + name);
        System.out.println("Product Description: " + description);
        System.out.println("Product Store Price: " + storeprice);
        System.out.println("Product Retail Price: " + retailprice);
        System.out.println("Product Stock: " + stock);
        System.out.println("\n");

    }
}
