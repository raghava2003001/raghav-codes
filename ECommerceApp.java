import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Product class representing a product in the store
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// ShoppingCart class representing the user's shopping cart
class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Product item : items) {
            System.out.println("- " + item.getName() + " $" + item.getPrice());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

// Main class for running the E-commerce application
public class ECommerceApp {
    private static List<Product> products = new ArrayList<>();
    private static ShoppingCart cart = new ShoppingCart();

    public static void main(String[] args) {
        // Adding some sample products to the store
        products.add(new Product("Product 1", 10.0));
        products.add(new Product("Product 2", 20.0));
        products.add(new Product("Product 3", 30.0));

        // Displaying available products
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName() + " $" + products.get(i).getPrice());
        }

        // Shopping loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter product number to add to cart (0 to finish):");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= products.size()) {
                Product selectedProduct = products.get(choice - 1);
                cart.addItem(selectedProduct);
                System.out.println(selectedProduct.getName() + " added to cart.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        // Displaying final cart and total
        cart.displayCart();
        System.out.println("Total: $" + cart.calculateTotal());
    }
}
