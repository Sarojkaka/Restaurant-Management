import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;

import com.codeinteracts.ems.Employee;
import com.codeinteracts.ems.EmployeeType;
import com.codeinteracts.ems.Gender;

import rms.DBConnection;
import rms.testrms;

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
			pst.setDouble(2, addmenu.getMenuPrice());
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

			// String query = "SELECT * from menu";
			String query = "SELECT menu.menu_id,category.cat_name,menu.menu_name,menu_description,menu.menu_price from menu "
					+ "inner join category on menu.cat_id=category.cat_id group by 1,2,3,4,5 ";

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			System.out.println("+===================================+");
			System.out.println("           RESTAURANT MENU          ");
			System.out.println("+====================================+");
			while (results.next()) {
				System.out.println(results.getString(2));
				System.out.println(
						results.getInt(1) + "." + "" + results.getString(3) + " Price: " + "$" + results.getDouble(5));
				System.out.print("Description: " + results.getString(4));
				System.out.println("");
			}
			System.out.println("+====================================+");

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

			pst.setDouble(2, editmenu.getMenuPrice());

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

			String updatequery = "UPDATE customer SET cust_firstname = ?,cust_lastname = ?,cust_phone = ? WHERE cust_id = "
					+ editcust.getCusId();

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

	@Override
	public void viewOrderbyCategory(Restaurant viewOrderbyCategory)
			throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		Statement statement = null;

		// Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT menu.menu_id,menu.menu_name,menu_description,menu.menu_price FROM menu INNER JOIN category ON category.cat_id = menu.cat_id where menu.cat_id = "
					+ viewOrderbyCategory.getCatId();

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				System.out.println(
						results.getInt(1) + ".> " + "" + results.getString(2) + ", Price: $" + results.getDouble(4));
				System.out.println("Description: " + results.getString(3));
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
	public void viewBilling(Restaurant viewBilling) throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;

		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT menu.menu_id,menu.menu_name,menu_description,menu.menu_price,category.cat_name FROM menu LEFT JOIN category ON category.cat_id = menu.cat_id where menu.cat_id = "
					+ viewBilling.getCatId();
			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			if (results.next()) {
				System.out.println("" + results.getString(5));

				while (results.next()) {
					System.out.println(
							results.getInt(1) + "." + "" + results.getString(2) + ", Price: $" + results.getDouble(4));
					System.out.println("Description: " + results.getString(3));
				}

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
	public void addorder(Restaurant addorder) throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String insertQuery = "insert into ordering(order_date,order_takeby,table_no,order_qty,menu_id,cust_id) values (?,?,?,?,?,?);";

			pst = con.prepareStatement(insertQuery);

			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pst.setDate(1, sqlDate);
			pst.setString(2, addorder.getOrderTakenBy());
			pst.setInt(3, addorder.getTableNo());
			pst.setInt(4, addorder.getQty());
			pst.setInt(5, addorder.getMenuId());
			pst.setInt(6, addorder.getCustId());

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
	public void login(String username, String password) throws IOException, ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from login where username = ? and password = ?";
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			ps = con.prepareStatement(query);
			Restaurant testrms = new Restaurant(username, password);
			// set the parameter
			ps.setString(1, testrms.getUsername());
			ps.setString(2, testrms.getPassword());
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("Welcome, " + rs.getString("firstname") + " " + rs.getString("lastname"));
				;
			}

		} finally {
			if (rs != null)
				rs.close();
			ps.close();
			con.close();
		}

	}

	public Restaurant searchByUsernameAndPassword(String username, String password)throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		Statement statement = null;
		Restaurant rms = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String query = "Select * from login where username='"+username+"' and password='"+password+"'";
			
			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				rms = new Restaurant();
				rms.setUserid(results.getInt(1));
				rms.setFirstname(results.getString(2));
				rms.setLastname(results.getString(3));
				rms.setGender(Gender.getByValue(results.getString(4)));
				rms.setUsername(results.getString(5));
				rms.setPassword(results.getString(6));
				rms.setUsertype(UserType.valueOf(results.getString(7)));
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return rms;
		
	}
}