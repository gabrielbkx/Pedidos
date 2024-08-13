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

        // Coleata de dados para a criação do objeto cliente
        System.out.println("Enter client data");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email:");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client c = new Client(name, email, birthDate);

        System.out.println("Enter order data ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),c,status);

        System.out.print("How many items to this order?: ");
        int n = sc.nextInt();

        //Coleta de dados para a criaçao do objeto produto/product
        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (1 + i) + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productPrice, productName);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(product, productPrice, quantity);

            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMMARY ");
        System.out.println(order);


        sc.close();
    }
}
