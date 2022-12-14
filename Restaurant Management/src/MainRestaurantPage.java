import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainRestaurantPage {

	static int choice = 0;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {

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
			}else if(choice == 3) {
				customer();
			}
		}
	}

	private static void customer()throws ClassNotFoundException, IOException, SQLException {
		RestaurantService restaurantService = new RestaurantService();
		Customer cust = null;
		
		System.out.println("1.Add Customer");
		System.out.println("2.View Customer");
		System.out.println("3.Edit Customer");
		System.out.println("4.Delete Customer");
		
		System.out.println("Enter Your Choice: ");
		choice = sc.nextInt();
		
		if(choice == 1) {
			System.out.println("Enter Customer First Name: ");
			String firstname = sc.next();
			System.out.println("Enter Customer Last Name: ");
			String lastname = sc.next();
			System.out.println("Enter Customer Phone Number: ");
			
			Integer phone = sc.nextInt();
//			if(phone <= 10) {
//				System.out.println("Enter 10 digit number");
//			}
			Customer addcust = new Customer(firstname, lastname, phone);
			try {
				cust = restaurantService.addCustomer(addcust);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(choice == 2) {
			RestaurantService.viewAllCustomer();
		}else if(choice == 3) {
			RestaurantService.viewAllCustomer();
			System.out.println("Choose Customer:");
			Integer custId = sc.nextInt();
			System.out.println("Enter Customer First Name: ");
			String firstname = sc.next();
			System.out.println("Enter Customer Last Name: ");
			String lastname = sc.next();
			System.out.println("Enter Customer Phone Number: ");
			Integer phone = sc.nextInt();
			
			Customer editcust = new Customer(custId,firstname, lastname, phone);
			try {
				editcust = restaurantService.editCustomer(editcust);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else if(choice == 4){
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
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < 5; i++) {
				String menuName = sc.next();

				System.out.println("Enter Menu Price: ");
				Integer menuPrice = sc.nextInt();

				System.out.println("Enter Menu Description");
				String menuDescription = sc.next();

				Restaurant addmenu = new Restaurant(catId, menuName, menuPrice, menuDescription);

				try {
					menu = restaurantService.addmenu(addmenu);
				} catch (Exception e) {
					System.out.println("Can't Add Menu. Please try again later.");
					e.printStackTrace();
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
			Integer menuPrice = sc.nextInt();

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
				Scanner sc = new Scanner(System.in);
				for (int i = 0; i < 5; i++) {
					String category = sc.nextLine();
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