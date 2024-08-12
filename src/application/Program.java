package application;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        Date now = Date.from(Instant.now());

        // Dados do cliente
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date date = sdf.parse(sc.next());
        Client c = new Client(name, email, date);
        sc.nextLine();

        // Dados do produto1
        System.out.println("Enter order data ");
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("How many itens for this order?: ");
        int n = sc.nextInt();
        sc.nextLine();

        Order order = new Order(now, c, OrderStatus.valueOf(status));

        // Dados do produto2
        for (int m = 0; m < n; m++) {
            System.out.println("Enter #" + (m + 1) + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Product quantity: ");
            int productQuantity = sc.nextInt();
            sc.nextLine();

            Product p = new Product(productPrice, productName, productQuantity);
            OrderItem o = new OrderItem(p, p.getPrice(), productQuantity);
            order.addItem(o);
        }

        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + order.getMoment());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client data: " + c);
        System.out.println("Order itenm: ");

        sc.close();
    }
}
