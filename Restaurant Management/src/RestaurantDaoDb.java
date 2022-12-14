import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantDaoDb implements RestaurantDaoInterface {

	private final static String USERNAME = "root";

	private final static String PASSWORD = "root";

	private final static String URL = "jdbc:mysql://localhost:3306/rms";

	@Override
	public void addCategory(Restaurant addcategory) throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String insertQuery = "insert into category(cat_name) values (?);";

			pst = con.prepareStatement(insertQuery);

			pst.setString(1, addcategory.getCategory());

			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;
		} catch (Exception e) {

		}

	}

	@Override
	public void viewAllCategory() throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;

		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from category";

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				System.out.println(results.getInt(1) + "." + "Category Name: " + results.getString(2));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void editCategory(Restaurant editcategory) throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String updatequery = "UPDATE category SET cat_name = ? WHERE cat_id = " + editcategory.getCatId();

			pst = con.prepareStatement(updatequery);

			pst.setString(1, editcategory.getCategory());

			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void deleteCategory(Restaurant deletecategory) throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String deletequery = "DELETE FROM category WHERE cat_id = " + deletecategory.getCatId();

			pst = con.prepareStatement(deletequery);

			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void addmenu(Restaurant addmenu) throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;

		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String insertQuery = "insert into menu(menu_name,menu_price,menu_description,cat_id) values (?,?,?,?);";

			pst = con.prepareStatement(insertQuery);

			pst.setString(1, addmenu.getMenuName());
			pst.setInt(2, addmenu.getMenuPrice());
			pst.setString(3, addmenu.getMenuDescription());
			pst.setInt(4, addmenu.getCatId());
			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;
		} catch (Exception e) {

		}

	}

	@Override
	public void viewAllMenu() throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;

		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from menu";

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				System.out.println(results.getInt(1) + "." + results.getString(2) + " Price: " + "$" + results.getInt(3)
						+ " Description: " + results.getString(4));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void editMenu(Restaurant editmenu) throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;

		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String updatequery = "UPDATE menu SET menu_name = ?, menu_price = ?, menu_description = ?, cat_id = ? WHERE menu_id = "
					+ editmenu.getMenuId();

			pst = con.prepareStatement(updatequery);

			pst.setString(1, editmenu.getMenuName());

			pst.setInt(2, editmenu.getMenuPrice());

			pst.setString(3, editmenu.getMenuDescription());

			pst.setInt(4, editmenu.getCatId());

			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteMenu(Restaurant deletemenu) throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String deletequery = "DELETE FROM menu WHERE menu_id = " + deletemenu.getMenuId();

			pst = con.prepareStatement(deletequery);

			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to Delete data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void addCustomer(Customer addCustomer) throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String insertQuery = "insert into customer(cust_firstname,cust_lastname,cust_phone) values (?,?,?);";

			pst = con.prepareStatement(insertQuery);

			pst.setString(1, addCustomer.getCusFirstName());
			pst.setString(2, addCustomer.getCusLastName());
			pst.setInt(3, addCustomer.getCusPhone());
			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;
		} catch (Exception e) {

		}

	}

	@Override
	public void viewAllCustomer() throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;

		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from customer";

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				System.out.println(results.getInt(1) + "." + "Full Name: " + results.getString(2) + " "
						+ results.getString(3) + " Phone: " + results.getInt(4));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void editCust(Customer editcust) throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;

		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String updatequery = "UPDATE customer SET cust_firstname = ?,cust_lastname = ?,cust_phone = ? WHERE cust_id = "+editcust.getCusId();
			
			pst = con.prepareStatement(updatequery);
			
			pst.setString(1, editcust.getCusFirstName());

			pst.setString(2, editcust.getCusLastName());

			pst.setInt(3, editcust.getCusPhone());

			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteCust(Customer deletecust) throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;

		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String deletequery = "DELETE FROM customer WHERE cust_id = " + deletecust.getCusId();

			pst = con.prepareStatement(deletequery);

			int resultvalue = pst.executeUpdate();

			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}