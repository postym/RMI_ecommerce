import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CartInterface extends Remote {
    void addProduct(ProductInterface product) throws RemoteException;

    List<ProductInterface> getProducts() throws RemoteException;

    double getTotal() throws RemoteException;

    void updateProductStocks(String productCode, double newStock) throws RemoteException;

    String viewAddedProducts() throws RemoteException; // Modified to return a String
}

