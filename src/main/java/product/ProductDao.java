package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.Connectionpool;

public class ProductDao {
	
	void saveProduct(Product product) {
		try {
			Connection con= Connectionpool.getConnection();
			PreparedStatement stm = con.prepareStatement("insert into product values(?,?,?,?)");
			stm.setInt(1, product.getId());
			stm.setString(2, product.getName());
			stm.setString(3, product.getType());
			stm.setDouble(4, product.getCost());
			stm.execute();
			con.close();
			System.out.println("saved successfullyyy");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void updateProduct(Product product, String type) {
		try {
			Connection con= Connectionpool.getConnection();
			if (type.equals("NAME")) {
				PreparedStatement stm = con.prepareStatement("update product set name=? where id=?");
				stm.setString(1, product.getName());
				stm.setInt(2, product.getId());
				stm.execute();
			}

			if (type.equals("COST")) {
				PreparedStatement stm2 = con.prepareStatement("update product set cost=? where id=?");
				stm2.setDouble(1, product.getCost());
				stm2.setInt(2, product.getId());
				stm2.execute();
			}
			if (type.equals("TYPE")) {
				PreparedStatement stm1 = con.prepareStatement("update product set type=? where id=?");
				stm1.setString(1, product.getType());
				stm1.setInt(2, product.getId());
				stm1.execute();
			}

			con.close();
			System.out.println("updated succesfullyy....");
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void productFindById(int id) {
		try {
			Connection con= Connectionpool.getConnection();
			String sql = "select * from product where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id1 = rs.getInt(1);
				String name1 = rs.getString(2);
				String type1 = rs.getString(3);
				double cost1 = rs.getDouble(4);
				System.out.println(id1);
				System.out.println(name1);
				System.out.println(type1);
				System.out.println(cost1);
			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}

	List<Product> displayAll() {
		List<Product> li = new ArrayList<Product>();
		try {
			Connection con= Connectionpool.getConnection();
			String sql = "select * from product";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				double cost = rs.getDouble(4);
				Product product = new Product(id, name, type, cost);
				li.add(product);
				con.close();

			}
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	void deleteProduct(int id) {
		try {
			Connection con= Connectionpool.getConnection();
			String sql = "delete from product where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			con.close();
			System.out.println("deleted succesfullyy....");
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
