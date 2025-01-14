package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date moment = Date.from(Instant.now());

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf1.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);

		System.out.println();

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(moment, status, client);

		System.out.println();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		System.out.println();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem items = new OrderItem(productQuantity, productPrice, product);
			order.addItem(items);
			
		}

		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order moment: " + sdf2.format(moment));
		System.out.println("Order status: " + status);
		System.out.println(client);
		System.out.println("Order items: ");
		System.out.println(order);

		sc.close();
	}

}
