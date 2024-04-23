import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {

            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server has been started...");

            Product Dress = new Product("PD1", "Dress", "Summer Dress", 380.91, 440.00, 100);
            Product Shoes = new Product("PD2", "Shoes", "Rubber Shoes", 441.72, 600.00, 100);
            Product Hoodie = new Product("PD3", "Hoodie", "Penshoppe Hoodie", 540.91, 740.00, 100);
            Product Watch = new Product("PD4", "Watch", "Men's Watch", 740.00, 840.00, 100);
            Product Necklace = new Product("PD5", "Necklace", "TBK Necklace", 340.91, 440.00, 100);

            Dress.ViewProducts();
            Shoes.ViewProducts();
            Hoodie.ViewProducts();
            Watch.ViewProducts();
            Necklace.ViewProducts();

            // Cart.viewAddedProducts();

            ProductInterface stub_dress = (ProductInterface) UnicastRemoteObject.exportObject(Dress, 0);
            ProductInterface stub_shoes = (ProductInterface) UnicastRemoteObject.exportObject(Shoes, 0);
            ProductInterface stub_hoodie = (ProductInterface) UnicastRemoteObject.exportObject(Hoodie, 0);
            ProductInterface stub_watch = (ProductInterface) UnicastRemoteObject.exportObject(Watch, 0);
            ProductInterface stub_necklace = (ProductInterface) UnicastRemoteObject.exportObject(Necklace, 0);

            // Create and export the Cart as a remote object
            Cart cart = new Cart();
            CartInterface stubCart = (CartInterface) UnicastRemoteObject.exportObject(cart, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            registry.rebind("dress", stub_dress);
            registry.rebind("shoes", stub_shoes);
            registry.rebind("hoodie", stub_hoodie);
            registry.rebind("watch", stub_watch);
            registry.rebind("necklace", stub_necklace);
            registry.rebind("cart", stubCart);

            System.out.println("Exporting and binding of Objects has been completed...");

        } catch (Exception e) {
            System.out.println("Some server error..." + e);
        }

    }
}

// CLI Server - start rmiregistry 9100
// CLI Server - compile and run
// CLI Client - compile and run

