import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote{
    // Lets us define API
    public String ProductCode() throws RemoteException;
    public String Name() throws RemoteException;
    public String Description() throws RemoteException;
    public double StorePrice() throws RemoteException;
    public double RetailPrice() throws RemoteException;
    public double Stock() throws RemoteException;
    // public void changeProductName(String newName) throws RemoteException;

    public void ViewProducts() throws RemoteException;
    public void setStock(double newStock) throws RemoteException;
}

