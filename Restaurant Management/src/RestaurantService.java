import java.io.IOException;
import java.sql.SQLException;

public class RestaurantService {

	public Restaurant addCategory(Restaurant addcategory) throws IOException, SQLException, ClassNotFoundException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.addCategory(addcategory);
		System.out.println("Category Save successfully!");
		return addcategory;
	}

	public static void viewAllCategory() throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.viewAllCategory();

	}

	public Restaurant editCategory(Restaurant editcategory) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.editCategory(editcategory);
		System.out.println("Category Updated successfully!");
		return editcategory;
	}

	public Restaurant deleteCategory(Restaurant deletecategory)
			throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.deleteCategory(deletecategory);
		System.out.println("Category Deleted successfully!");
		return deletecategory;
	}

	public Restaurant addmenu(Restaurant addmenu) throws IOException, SQLException, ClassNotFoundException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.addmenu(addmenu);
		System.out.println("Menu Save successfully!");
		return addmenu;
	}

	public static void viewAllMenu() throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.viewAllMenu();

	}

	public Restaurant editMenu(Restaurant editmenu) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.editMenu(editmenu);
		System.out.println("Menu Updated successfully!");
		return editmenu;
	}

	public Restaurant deleteMenu(Restaurant deletemenu) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.deleteMenu(deletemenu);
		System.out.println("Menu Deleted successfully!");
		return deletemenu;
	}

	public Customer addCustomer(Customer addcustomer) throws IOException, SQLException, ClassNotFoundException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.addCustomer(addcustomer);
		System.out.println("Customer Save successfully!");
		return addcustomer;
	}

	public static void viewAllCustomer() throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.viewAllCustomer();

	}

	public Customer editCustomer(Customer editcust) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.editCust(editcust);
		System.out.println("Customer Edited Successfully");
		return editcust;
	}

	public Customer deletecust(Customer deletecust) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.deleteCust(deletecust);
		System.out.println("Customer Deleted Successfully");
		return deletecust;
	}

	public static Restaurant viewOrderbyCategory(Restaurant viewOrderbyCategory) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.viewOrderbyCategory(viewOrderbyCategory);
		return viewOrderbyCategory;
	}

	public static Restaurant viewBilling(Restaurant viewBilling) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.viewBilling(viewBilling);
		return viewBilling;

	}
	public static Restaurant addOrder(Restaurant addorder) throws IOException, SQLException, ClassNotFoundException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.addorder(addorder);
		System.out.println("Order Save successfully!");
		return addorder;
	}

	public static Restaurant login(String username, String password) throws ClassNotFoundException, IOException, SQLException {
		RestaurantDaoInterface dao = new RestaurantDaoDb();
		dao.login(username, password);
		System.out.println("Login successfully!");
		return null;
	}

	public static Restaurant searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}