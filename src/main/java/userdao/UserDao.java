package userdao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import connection.Connectionpool;
import product.Product;

public class UserDao {
	
	private User existingUser;

	void saveUser(User user1) {
		try {
			Connection con=Connectionpool.getConnection();
			PreparedStatement stm = con.prepareStatement("insert into usertable values(?,?,?,?,?)");
			stm.setInt(1, user1.getId());
			stm.setString(2, user1.getUsername());
			stm.setString(3, user1.getPassword());
			stm.setString(4, user1.getEmail());
			stm.setLong(5, user1.getPhono());
			stm.execute();
			con.close();
			System.out.println("saved successfullyyy");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	User userFindById(int id) {
		try {
			Connection con= Connectionpool.getConnection();
			String sql = "select * from usertable where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				long phono=rs.getLong(5);
				System.out.println(id1);
				System.out.println(username);
				System.out.println(password);
				System.out.println(email);
				System.out.println(phono);
				return new User(id1, username,password,email,phono);
			}
			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	List<User> displayAll(){
		List<User> li = new ArrayList<User>();
		try {
			Connection con= Connectionpool.getConnection();
			String sql = "select * from usertable";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String email=rs.getString(4);
				long phono=rs.getLong(5);
				User user = new User(id, username, password, email,phono);
				li.add(user);
				con.close();

			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}
	void deleteUser(int id) {
		try {
			Connection con= Connectionpool.getConnection();
			String sql = "delete from usertable where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			con.close();
			System.out.println("deleted succesfullyy....");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void updateUser(User user1) {
		User exsitingUser = userFindById(user1.getId());
//		System.out.println(exsitingUser.getUsername());
//		System.out.println(exsitingUser.getPassword());
//		System.out.println(exsitingUser.getEmail());
//		System.out.println(exsitingUser.getPhono());
		if (exsitingUser != null) {
			if (user1.getUsername() != null) {
				exsitingUser.setUsername(user1.getUsername());
			}
			if (user1.getPassword() != null) {
				exsitingUser.setPassword(user1.getPassword());
			}
			if (user1.getEmail() != null) {
				exsitingUser.setEmail(user1.getEmail());
			}
			if(user1.getPhono()!=0) {
				exsitingUser.setPhono(user1.getPhono());
			}

			
			try {
				Connection con= Connectionpool.getConnection();
				PreparedStatement preparedStatement = con
						.prepareStatement("update usertable set username=?,password=?,email=?,phono=? where id=?");
				preparedStatement.setString(1, exsitingUser.getUsername());
				preparedStatement.setString(2, exsitingUser.getPassword());
				preparedStatement.setString(3, exsitingUser.getEmail());
				preparedStatement.setLong(4, exsitingUser.getPhono());
				preparedStatement.setInt(5, exsitingUser.getId());

				preparedStatement.executeUpdate();
				con.close();
				System.out.println("updated successfully....");
			} 
			 catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		System.out.println(exsitingUser.getUsername());
		System.out.println(exsitingUser.getPassword());
		System.out.println(exsitingUser.getEmail());
		System.out.println(exsitingUser.getPhono());
		

	}
	User findUserByEmailOrPassword(String email,String password1) {
		try {
			Connection con= Connectionpool.getConnection();
			String sql = "select * from usertable where email=? and password=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password1);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String email1 = rs.getString(4);
				long phono=rs.getLong(5);
				System.out.println(id1);
				System.out.println(username);
				System.out.println(password);
				System.out.println(email1);
				System.out.println(phono);
				return new User(id1, username,password,email1,phono);
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
