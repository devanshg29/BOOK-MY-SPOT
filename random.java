import java.sql.Connection;
import java.sql.DriverManager;
public class random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  

		      // variables
		      final String url = "jdbc:mysql:///bookmyspot";
		      final String user = "root";
		      final String password = "root";

		      // establish the connection
		      Connection con = DriverManager.getConnection(url, user, password);

		      // display status message
		      if (con == null) {
		         System.out.println("JDBC connection is not established");
		         return;
		      } else
		         System.out.println("Congratulations," + " JDBC connection is established successfully.\n");

		      // close JDBC connection
		      con.close();  
			}catch(Exception e){ System.out.println(e);}

	}

}
