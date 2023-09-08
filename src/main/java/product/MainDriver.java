package product;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDao dao = new ProductDao();
		System.out.println("welcome");
		System.out.println("1.saveProducts");
		System.out.println("2.updateProducts");
		System.out.println("3.productfindbyid");
		System.out.println("4.displayall");
		System.out.println("5.deletebyid");
		System.out.println("enter your choice");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter type");
			String type = sc.next();
			System.out.println("enter cost");
			int cost = sc.nextInt();
			Product product = new Product(id, name, type, cost);
			dao.saveProduct(product);
			break;
		case 2:
			System.out.println("1.update name\n 2.update type\n 3.update cost");
			System.out.println("enter your choice");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1:
				System.out.println("enter name that to be updated");
				String updated_name = sc.next();
				System.out.println("enter id of the product");
				int exixted_id = sc.nextInt();
				Product product2 = new Product(updated_name, exixted_id);
				dao.updateProduct(product2, "NAME");
				break;
			case 2:
				System.out.println("enter type that has to be updated");
				String up_type = sc.next();
				System.out.println("enter id of the product");
				int exixted_id1 = sc.nextInt();
				Product product3 = new Product(up_type, exixted_id1);
				product3.setType(up_type);
				dao.updateProduct(product3, "TYPE");
				break;
			case 3:
				System.out.println("enter cost");
				double up_cost = sc.nextDouble();
				System.out.println("enter id of the product");
				int exixted_id3 = sc.nextInt();
				Product product4 = new Product(up_cost, exixted_id3);
				product4.setCost(up_cost);
				dao.updateProduct(product4, "COST");
				
			}
			break;

		case 3:
			System.out.println("enter the id");
			int id1 = sc.nextInt();
			dao.productFindById(id1);
			break;

		case 4:
			System.out.println(dao.displayAll());
			break;
		case 5:
			System.out.println("enter id");
			int id2 = sc.nextInt();
			dao.deleteProduct(id2);
		}

	}
}
