import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainRestaurantPage {

	static int choice = 0;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {

		Restaurant login = null;
		System.out.println("Enter Username: ");
		String username = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();

		login = RestaurantService.login(username, password);

		if (login != null) {
			System.out.println("User logged in Successfully.");
		} else {
			System.out.println("Login Failed. Incorrect username/password. Try again.");

		}

		System.out.println("Welcome, " + login.getFirstname() + " " + login.getLastname());

		int choice = 0;

		if (login.getUsertype() == UserType.ADMIN) {

			// Admin functionalities
			while (true) {
				System.out.println("-----------------------");
				System.out.println("1. Voter Registration");
				System.out.println("2. Candidate Registration");
				System.out.println("3. View All Voter List ");
				System.out.println("4. View All Candidate List");
				System.out.println("5. Voting process ");
				System.out.println("6. Voting Result ");
				System.out.println("7. Logout");
				System.out.println("Enter your choice::");
				choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("this is test");

				} else {
					System.err.println("Invalid Selection");
				}
			}
		} else if (login.getUsertype() == UserType.USER) {
			// User functionalities
			while (true) {
				System.out.println("--------------------");
				System.out.println("1. View my Details");
				System.out.println("2. Vote");
				System.out.println("3. Logout");
				System.out.println("Enter your choice::");
				choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("Enter Any Number To Continue:: ");
					int id = sc.nextInt();

					Restaurant rest = RestaurantService.searchById(id);
					if (rest != null) {
						System.out.println(rest.toString());
					} else {
						System.out.println("\n\n\n Records not present. \n\n\n");

					}

				}
			}
		}
	}

	private static void admin() throws ClassNotFoundException, IOException, SQLException {

		while (true) {
			System.out.println("1.Category");
			System.out.println("2.Menu");
			System.out.println("3.Customer");
			System.out.println("4.Order");
			System.out.println("5.Billing");
			System.out.println("Enter your choice::");
			choice = sc.nextInt();
			if (choice == 1) {
				Category();
			} else if (choice == 2) {
				menu();
			} else if (choice == 3) {
				customer();
			} else if (choice == 4) {
				order();
			} else if (choice == 5) {
				System.out.println("Enter Order No: ");
				int orderno = sc.nextInt();
				Restaurant vieworder = new Restaurant(orderno);
				try {

				} catch (Exception e) {
					RestaurantService.viewBilling(vieworder);
				}

			}
		}

	}

	private static void order() throws ClassNotFoundException, IOException, SQLException {

		while (true) {
			System.out.println("1.View Menu by Category");
			System.out.println("2.Add Order");
			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();
			if (choice == 1) {
				viewOrderbyCat();
			} else if (choice == 2) {
				addorder();
			}
		}
	}

	private static void addorder() throws ClassNotFoundException, IOException, SQLException {

		System.out.println("Do you want to input Customer Details");
		System.out.println("Press N for to input Customer As Walkin Customer");
		System.out.println("Press Y for Yes and N for N : ");
		String again = sc.next();
		if (again.equalsIgnoreCase("Y")) {

			System.out.println("Press 1 for entey as Walk-In Customer");
			int custId = sc.nextInt();

			System.out.println("Order Take By");
			String ordertakenby = sc.next();

			System.out.println("Enter Table No:");
			int tableno = sc.nextInt();

			System.out.println("Enter Menu ID : ");
			RestaurantService.viewAllMenu();
			int menuId = sc.nextInt();

			System.out.println("How Many Quantity You Want Order: ");
			int qty = sc.nextInt();

			Restaurant addorder = new Restaurant(ordertakenby, tableno, qty, menuId, custId);
			try {
				addorder = RestaurantService.addOrder(addorder);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private static void viewOrderbyCat() throws ClassNotFoundException, IOException, SQLException {
		RestaurantService restaurantService = new RestaurantService();
		System.out.println("List of Menu Category");
		RestaurantService.viewAllCategory();
		System.out.println("Choose Category : ");
		Integer catId = sc.nextInt();
		System.out.println("List of Menu");
		Restaurant viewOrderbyCategory = new Restaurant(catId);
		try {
			viewOrderbyCategory = restaurantService.viewOrderbyCategory(viewOrderbyCategory);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void customer() throws ClassNotFoundException, IOException, SQLException {
		RestaurantService restaurantService = new RestaurantService();
		Customer cust = null;

		System.out.println("1.Add Customer");
		System.out.println("2.View Customer");
		System.out.println("3.Edit Customer");
		System.out.println("4.Delete Customer");

		System.out.println("Enter Your Choice: ");
		choice = sc.nextInt();

		if (choice == 1) {
			addcustomer();

		} else if (choice == 2) {
			RestaurantService.viewAllCustomer();
		} else if (choice == 3) {
			RestaurantService.viewAllCustomer();
			System.out.println("Choose Customer:");
			Integer custId = sc.nextInt();
			System.out.println("Enter Customer First Name: ");
			String firstname = sc.next();
			System.out.println("Enter Customer Last Name: ");
			String lastname = sc.next();
			System.out.println("Enter Customer Phone Number: ");
			Integer phone = sc.nextInt();

			Customer editcust = new Customer(custId, firstname, lastname, phone);
			try {
				editcust = restaurantService.editCustomer(editcust);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (choice == 4) {
			RestaurantService.viewAllCustomer();
			System.out.println("Choose Customer ID for delete:");
			Integer custId = sc.nextInt();
			Customer deletecust = new Customer(custId);
			try {
				deletecust = restaurantService.deletecust(deletecust);
			} catch (Exception e) {
				System.out.println("Can't delete Category. Please try again later.");
			}
		}
	}

	private static void addcustomer() throws ClassNotFoundException, IOException, SQLException {
		RestaurantService restaurantService = new RestaurantService();
		Customer cust = null;
		System.out.println("Enter Customer First Name: ");
		String firstname = sc.next();
		System.out.println("Enter Customer Last Name: ");
		String lastname = sc.next();
		System.out.println("Enter Customer Phone Number: ");

		Integer phone = sc.nextInt();
//		if(phone <= 10) {
//			System.out.println("Enter 10 digit number");
//		}
		Customer addcust = new Customer(firstname, lastname, phone);
		try {
			cust = restaurantService.addCustomer(addcust);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void menu() throws ClassNotFoundException, IOException, SQLException {
		RestaurantService restaurantService = new RestaurantService();

		Restaurant menu = null;

		// menu category

		System.out.println("1. Create Menu: ");
		System.out.println("2. View Menu: ");
		System.out.println("3. Edit Menu: ");
		System.out.println("4. Delete Menu: ");
		System.out.println("Enter your choice::");
		choice = sc.nextInt();

		// checking choice
		if (choice == 1) {

			System.out.println("List Menu Category");
			RestaurantService.viewAllCategory();
			System.out.println("Choose Category : ");
			Integer catId = sc.nextInt();

			System.out.println("Enter Menu: ");

			// n is the number of strings we want to enter
			Scanner sc1 = new Scanner(System.in);
			for (int i = 0; i < 5; i++) {
				String menuName = sc1.nextLine();

				System.out.println("Enter Menu Price: ");
				Double menuPrice = sc.nextDouble();
				System.out.println("Enter Menu Description");
				for (int j = 0; j < 20; j++) {
					String menuDescription = sc1.nextLine();

					Restaurant addmenu = new Restaurant(catId, menuName, menuPrice, menuDescription);

					try {
						menu = restaurantService.addmenu(addmenu);
					} catch (Exception e) {
						System.out.println("Can't Add Menu. Please try again later.");
						e.printStackTrace();
					}
				}
			}
		} else if (choice == 2) {
			RestaurantService.viewAllMenu();
		} else if (choice == 3) {

			System.out.println("List of Menu");
			RestaurantService.viewAllMenu();
			System.out.println("Choose Menu ID: ");
			Integer menuId = sc.nextInt();
			System.out.println("Enter Menu Name: ");
			String menuName = sc.next();

			System.out.println("Enter Menu Price: ");
			Double menuPrice = sc.nextDouble();

			System.out.println("Enter Menu Description");
			String menuDescription = sc.next();

			System.out.println("List of Category");
			RestaurantService.viewAllCategory();
			System.out.println("Choose Category ID: ");
			Integer catId = sc.nextInt();

			Restaurant editmenu = new Restaurant(menuId, menuName, menuPrice, menuDescription, catId);
			try {
				editmenu = restaurantService.editMenu(editmenu);
			} catch (Exception e) {
				System.out.println("Can't edit Menu. Please try again later.");
			}

		} else if (choice == 4) {

			System.out.println("List of Menu");

			RestaurantService.viewAllMenu();

			System.out.println("Choose Menu ID for Delete: ");

			int menuId = sc.nextInt();

			Restaurant deletemenu = new Restaurant(menuId);
			try {
				deletemenu = restaurantService.deleteMenu(deletemenu);
			} catch (Exception e) {
				System.out.println("Can't delete Category. Please try again later.");
			}

		} else {
			System.err.println("Invalid Selection");
		}
	}

	private static void Category() throws ClassNotFoundException, IOException, SQLException {

		RestaurantService restaurantService = new RestaurantService();

		Restaurant categ = null;

		// menu category
		while (true) {
			System.out.println("1. Create Category: ");
			System.out.println("2. View Category: ");
			System.out.println("3. Edit Category: ");
			System.out.println("4. Delete Category: ");
			System.out.println("Enter your choice::");
			choice = sc.nextInt();

			// checking choice
			if (choice == 1) {
				System.out.println("Enter Category Name: ");
				// n is the number of strings we want to enter
				Scanner sc1 = new Scanner(System.in);
				for (int i = 0; i < 5; i++) {
					String category = sc1.nextLine();
					Restaurant cate = new Restaurant(category);

					try {
						categ = restaurantService.addCategory(cate);
					} catch (Exception e) {
						System.out.println("Can't Add Category. Please try again later.");
						e.printStackTrace();
					}
				}

			} else if (choice == 2) {
				RestaurantService.viewAllCategory();

			} else if (choice == 3) {

				System.out.println("Enter Category ID: ");
				Integer catId = sc.nextInt();

				System.out.println("Enter Category Name: ");
				String category = sc.next();

				Restaurant editcategory = new Restaurant(catId, category);
				try {
					editcategory = restaurantService.editCategory(editcategory);
				} catch (Exception e) {
					System.out.println("Can't edit Category. Please try again later.");
				}

			} else if (choice == 4) {

				System.out.println("List of Category");

				RestaurantService.viewAllCategory();

				System.out.println("Choose Category ID for Delete: ");

				Integer catId = sc.nextInt();

				Restaurant deletecategory = new Restaurant(catId);
				try {
					deletecategory = restaurantService.deleteCategory(deletecategory);
				} catch (Exception e) {
					System.out.println("Can't delete Category. Please try again later.");
				}

			} else {
				System.err.println("Invalid Selection");
			}
		}
	}
}