package com.cg.oss.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.oss.entities.Order;
import com.cg.oss.entities.User;
import com.cg.oss.exception.OSSException;
import com.cg.oss.service.IOrderService;
import com.cg.oss.service.IloginService;
import com.cg.oss.service.LoginServiceImpl;
import com.cg.oss.service.OrderServiceImpl;

public class Application {
	public static IloginService login = new LoginServiceImpl();
	public static final Scanner scan = new Scanner(System.in);
	public static IOrderService orderservice = new OrderServiceImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu[] menus = Menu.values();
		Menu selectedMenu = null;

		System.out.print("Enter choice : ");
		int ch = scan.nextInt();
		if (ch >= 0 && ch <= menus.length) {
			selectedMenu = menus[ch];

			switch (selectedMenu) {
			case User:
				gouser();
				break;
			case Order:
				goorder();
				break;
			case Cart:
				gocart();
				break;
			case Product:
				goproduct();
				break;
			case Customer:
				gocustomer();
				break;

			default:
				break;
			}
		} else {
			selectedMenu = null;

		}

	}

//USER
	private static void gouser() {
		UserMenu[] menus = UserMenu.values();
		UserMenu selectedMenu = null;
		while (selectedMenu != UserMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (UserMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}
			System.out.println("Enter You Choice: ");
			Character choice = scan.next().charAt(0);
			switch (choice) {
			case '0':
				Login();
				break;
			case '1':
				Quit();
				break;
			}

		}

	}

	private static void Login() {
		// TODO Auto-generated method stub
		User user = null;
		System.out.println("0.New User");
		System.out.println("1.Existing user");
		Character choice1 = scan.next().charAt(0);
		System.out.println("Enter User ID ");
		String user_ID = scan.next();
		System.out.println("Enter Password ");
		String password = scan.next();
		System.out.println("Enter your Role...0.Customer or 1.Admin");
		Character choice2 = scan.next().charAt(0);
		String role = choice2 == '0' ? "Customer" : "Admin";
		user = new User(user_ID, password, role);

		switch (choice1) {
		case '0':
			try {
				{
					User found = login.addUser(user);
					if (found != null)
						System.out.println("user added");
					else {
						throw new OSSException("invalid user entry");
					}
				}
			} catch (OSSException e) {
				e.printStackTrace();
			}

			break;
		case '1':
			try {
				User found = login.validateUser(user);
				if (found != null)
					System.out.println("Welcome Back" + found.getRole());
				else {
					throw new OSSException("User not found");
				}
			} catch (OSSException e) {
				e.printStackTrace();
			}
			break;
		}

	}

//ORDER
	private static void goorder() {
		OrderMenu[] menus = OrderMenu.values();
		OrderMenu selectedMenu = null;

		while (selectedMenu != OrderMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (OrderMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case addOrder:
					doaddOrder();
					break;
				case updateOrder:
					doupdateOrder();
					break;
				case removeOrder:
					doremoveOrder();
					break;
				case viewOrder:
					doviewOrder();
					break;
				case viewAllOrders:
					doviewAllOrders();
					break;
				case viewAllOrdersByLocation:
					doviewAllOrdersByLocation();
					break;
				case viewAllOrderByUserId:
					doviewAllOrderByUserId();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;

			}

		}

	}

	private static void doaddOrder() {
		Order order = new Order();

		System.out.print("Enter order Id :");
		String orderId = scan.next();
		System.out.print("Enter User Id :");
		order.setUserId(scan.next());
		System.out.print("Enter Address id");
		order.setAddressId(scan.next());
		System.out.print("Order status:");
		order.setOrderStatus(scan.next());
		System.out.print("order date :");
		order.setOrderDate(LocalDate.parse(scan.next()));

	}

	private static void doupdateOrder() {
		/*
		 * System.out.print("Enter order Id :"); String orderId = scan.next();
		 * System.out.print("Enter User Id :"); String userId = scan.next(); // String
		 * try { orderservice.updateOrder(orderId); System.out.println("order updated");
		 * } catch (OSSException excep) { System.out.println(excep.getMessage()); }
		 */

	}

	private static void doremoveOrder() {

		/*
		 * System.out.print("Enter order Id :"); Order orderId = scan.next(); try {
		 * orderservice.removeOrder(orderId); System.out.println("order delete"); }
		 * catch (OSSException excep) { System.out.println(excep.getMessage()); }
		 */
	}

	private static void doviewOrder() {
		System.out.print("Enter order Id :");
		String orderID = scan.next();
		try {
			orderservice.viewOrder(orderID);
		} catch (OSSException excep) {
			System.out.println(excep.getMessage());
		}

	}

	private static void doviewAllOrders() {
		System.out.print("Enter order date :");
		LocalDate orderDate = LocalDate.parse(scan.next());
		try {
			orderservice.viewAllOrders(orderDate);
		} catch (OSSException excep) {
			System.out.println(excep.getMessage());
		}

	}

	private static void doviewAllOrdersByLocation() {

	}

	private static void doviewAllOrderByUserId() {

	}

	// CART
	private static void gocart() {
		CartMenu[] menus = CartMenu.values();
		CartMenu selectedMenu = null;

		while (selectedMenu != CartMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (CartMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case addProductToCart:
					doaddProductToCart();
					break;
				case removeProductFromCart:
					doremoveProductFromCart();
					break;
				case updateProductQuantity:
					doupdateProductQuantity();
					break;
				case removeAllProducts:
					doremoveAllProducts();
					break;
				case viewAllProducts:
					doviewAllProducts();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;

			}

		}

	}

	private static void doaddProductToCart() {

	}

	private static void doremoveProductFromCart() {

	}

	private static void doupdateProductQuantity() {

	}

	private static void doremoveAllProducts() {

	}

	private static void doviewAllProducts() {

	}

	private static void goproduct() {
		ProductMenu[] menus = ProductMenu.values();
		ProductMenu selectedMenu = null;

		while (selectedMenu != ProductMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (ProductMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case viewAllProducts:
					doaddOrder();
					break;
				case addProduct:
					doaddProduct();
					break;
				case updateProduct:
					doupdateProduct();
					break;
				case viewProduct:
					doviewProduct();
					break;
				case viewProductsByCategory:
					doviewProductsByCategory();
					break;
				case removeProduct:
					doremoveProduct();
					break;

				default:
					break;
				}
			} else {
				selectedMenu = null;

			}

		}

	}

	private static void doupdateProduct() {

	}

	private static void doaddProduct() {

	}

	private static void doviewProduct() {

	}

	private static void doviewProductsByCategory() {

	}

	private static void doremoveProduct() {

	}

//CUSTOMER
	private static void gocustomer() {
		CustomerMenu[] menus = CustomerMenu.values();
		CustomerMenu selectedMenu = null;

		while (selectedMenu != CustomerMenu.Quit) {
			System.out.println("Choice\tOperation");
			for (CustomerMenu menu : menus) {
				System.out.println(menu.ordinal() + "\t" + menu);
			}

			System.out.print("Enter choice : ");
			int ch = scan.nextInt();
			if (ch >= 0 && ch <= menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case addCustomer:
					doaddCustomer();
					break;
				case updateCustomer:
					doupdateCustomer();
					break;
				case removeCustomer:
					doremoveCustomer();
					break;
				case viewCustomer:
					doviewCustomer();
					break;
				case ViewAllCustomers:
					doviewAllCustomers();
					break;
				default:
					break;
				}
			} else {
				selectedMenu = null;

			}

		}

	}

	private static void doaddCustomer() {

	}

	private static void doupdateCustomer() {

	}

	private static void doremoveCustomer() {

	}

	private static void doviewCustomer() {

	}

	private static void doviewAllCustomers() {

	}

	private static void Quit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}