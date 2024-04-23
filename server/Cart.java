import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Cart implements CartInterface {
    private List<ProductInterface> addedProducts;

    public Cart() {
        this.addedProducts = new ArrayList<>();
    }

    @Override
    public void addProduct(ProductInterface product) throws RemoteException {
        addedProducts.add(product);
        System.out.println("Products added to cart: " + product.Name());
        try {
            // Display remaining stock
            int remainingStock = (int) product.Stock();
            System.out.println("Remaining stock for " + product.Name() + ": " + remainingStock);

            // Update displayed quantity
            product.setStock(remainingStock - 1);
        } catch (RemoteException e) {
            System.out.println("Error updating stock: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductInterface> getProducts() throws RemoteException {
        return addedProducts;
    }

    @Override
    public double getTotal() throws RemoteException {
        double total = 0;
        for (ProductInterface product : addedProducts) {
            total += product.StorePrice();
        }
        return total;
    }

    public void updateProductStocks(String productCode, double newStock) throws RemoteException {
        for (ProductInterface product : addedProducts) {
            if (product.ProductCode().equals(productCode)) {
                double currentStock = product.Stock();
                if (newStock >= 0 && newStock <= currentStock) {
                    product.setStock(currentStock - newStock);
                    return;
                } else {
                    System.out.println("No more stocks");
                    return;
                }
            }
        }
        System.out.println("Product not found in the cart");
    }

    @Override
    public String viewAddedProducts() throws RemoteException {
        StringBuilder stringBuilder = new StringBuilder();
        double total = 0.0;
        stringBuilder.append("Items in Cart:\n");
        for (ProductInterface product : addedProducts) {
            try {
                stringBuilder.append("Product Code: ").append(product.ProductCode()).append("\n");
                stringBuilder.append("Product Name: ").append(product.Name()).append("\n");
                stringBuilder.append("Product Description: ").append(product.Description()).append("\n");
                stringBuilder.append("Product Store Price: ").append(product.StorePrice()).append("\n");
                stringBuilder.append("Product Retail Price: ").append(product.RetailPrice()).append("\n");
                total += product.StorePrice();

                int currentStock = (int) product.Stock();
                stringBuilder.append("Product Stocks: ").append(currentStock).append("\n");
                stringBuilder.append("\n");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.append("Total: ").append(getTotal());
        return stringBuilder.toString();
    }
}
