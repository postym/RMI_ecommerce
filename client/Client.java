import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the references of exported object from RMI Registry...

            // locate the registry.
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            // Get the references of exported object from the RMI Registry...
            ProductInterface p1 = (ProductInterface) registry.lookup("dress");
            ProductInterface p2 = (ProductInterface) registry.lookup("shoes");
            ProductInterface p3 = (ProductInterface) registry.lookup("hoodie");
            ProductInterface p4 = (ProductInterface) registry.lookup("watch");
            ProductInterface p5 = (ProductInterface) registry.lookup("necklace");

            System.out.println("\nProduct Code: " + p1.ProductCode() + "\nProduct Name: " + p1.Name()
                    + "\nProduct Description: " + p1.Description() + "\nStore Price: " + p1.StorePrice()
                    + "\nRetail Price: " + p1.RetailPrice() + "\nStock: " + p1.Stock());

            System.out.println("\nProduct Code: " + p2.ProductCode() + "\nProduct Name: " + p2.Name()
                    + "\nProduct Description: " + p2.Description() + "\nStore Price: " + p2.StorePrice()
                    + "\nRetail Price: " + p2.RetailPrice() + "\nStock: " + p2.Stock());

            System.out.println("\nProduct Code: " + p3.ProductCode() + "\nProduct Name: " + p3.Name()
                    + "\nProduct Description: " + p3.Description() + "\nStore Price: " + p3.StorePrice()
                    + "\nRetail Price: " + p3.RetailPrice() + "\nStock: " + p3.Stock());

            System.out.println("\nProduct Code: " + p4.ProductCode() + "\nProduct Name: " + p4.Name()
                    + "\nProduct Description: " + p4.Description() + "\nStore Price: " + p4.StorePrice()
                    + "\nRetail Price: " + p4.RetailPrice() + "\nStock: " + p4.Stock());

            System.out.println("\nProduct Code: " + p5.ProductCode() + "\nProduct Name: " + p5.Name()
                    + "\nProduct Description: " + p5.Description() + "\nStore Price: " + p5.StorePrice()
                    + "\nRetail Price: " + p5.RetailPrice() + "\nStock: " + p5.Stock());

        } catch (Exception e) {
            System.out.println("Client side error..." + e);
        }
    }
}
