import java.io.IOException;
import java.sql.SQLException;


public interface RestaurantDaoInterface {

	public void addCategory(Restaurant addcategory) throws IOException, ClassNotFoundException, SQLException;

	public void viewAllCategory() throws IOException, ClassNotFoundException, SQLException;

	public void editCategory(Restaurant editcategory) throws IOException, ClassNotFoundException, SQLException;

	public void deleteCategory(Restaurant deletecategory) throws IOException, ClassNotFoundException, SQLException;
	
	public void addmenu(Restaurant addmenu) throws IOException, ClassNotFoundException, SQLException;

	public void viewAllMenu()throws IOException, ClassNotFoundException, SQLException;
	
	public void editMenu(Restaurant editmenu) throws IOException, ClassNotFoundException, SQLException;
	
	public void deleteMenu(Restaurant deletemenu)throws IOException, ClassNotFoundException, SQLException;
	
	public void addCustomer(Customer addCustomer) throws IOException, ClassNotFoundException, SQLException;

	public void viewAllCustomer()throws IOException, ClassNotFoundException, SQLException;

	public void editCust(Customer editcust)throws IOException, ClassNotFoundException, SQLException;

	public void deleteCust(Customer deletecust)throws IOException, ClassNotFoundException, SQLException;
}
