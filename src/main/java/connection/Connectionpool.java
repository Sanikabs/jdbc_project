package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connectionpool {
	private static List<Connection> connectionpool= new ArrayList<Connection>();
	private static String url="jdbc:postgresql://localhost:5432/prdouctManagement?user=postgres&password=root";
	private static String driverPath="org.postgresql.Driver";
	static int  pool_size=5;
	  static {
		try {
			Class.forName(driverPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	  }
	  public static Connection getConnection() {
		  if(!connectionpool.isEmpty()) {
			  return connectionpool.remove(0);
		  }else {
			  return createConnection();
		  }
	  }
	  public static void reciveconnection(Connection connection) {
		  if(connectionpool.size()<pool_size) {
			  connectionpool.add(connection);
		  }else {
			  try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
	  }
	  public static Connection createConnection() {
		  Connection connection=null;
		  try {
			connection=DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  return connection;
	  }
}
