import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	private final static String USERNAME = "root";

	private final static String PASSWORD = "root";

	private final static String URL = "jdbc:mysql://localhost:3306/rms";
	
	public static void main(String[] args) {
		
		
		
		
		Connection con = null;

		PreparedStatement pst = null;
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("ID");
			Integer catId = sc.nextInt();
//			System.out.println("Category");
//			String cat_name = sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//			String insertQuery = "UPDATE category SET cat_name = ? WHERE cat_id = " + catId;
		
			String deleteQuery = "DELETE FROM category WHERE cat_id = " + catId;
			pst = con.prepareStatement(deleteQuery);
//			pst = con.prepareStatement(insertQuery);

//			pst.setString(1, cat_name);

			int resultvalue = pst.executeUpdate();
			System.out.println("Success");
			if (resultvalue == 0) {
				System.out.println("Failed to insert data. Check your data and try again : ");

			}
			pst.close();
			con.close();
			return;
		} catch (Exception e) {

		}

	}
}