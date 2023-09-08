package userdao;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("welcome");
		System.out.println("1.saveuser");
		System.out.println("2.finduserbyid");
		System.out.println("3.display all");
		System.out.println("4.delete user");
		System.out.println("5.update usertable");
		System.out.println("6.find by email and password");
		System.out.println("enter your choice");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter username");
			String username = sc.next();
			System.out.println("enter password");
			String password = sc.next();
			System.out.println("enter email");
			String email = sc.next();
			System.out.println("enter number");
			long phono = sc.nextLong();
			User user1 = new User(id, username, password, email, phono);
			dao.saveUser(user1);
			break;
		case 2:
			System.out.println("enter id");
			int id1 = sc.nextInt();
			dao.userFindById(id1);
			break;
		case 3:
			System.out.println(dao.displayAll());
			break;
		case 4:
			System.out.println("enter id");
			int id2 = sc.nextInt();
			dao.deleteUser(id2);
			break;
		case 5:
			User user = new User();
			System.out.println("1.update username");
			System.out.println("2.update password");
			System.out.println("3.update email");
			System.out.println("4.update phono");
			System.out.println("enter your choice");
			int choice1 = sc.nextInt();
			switch (choice1) {
			case 1:
				System.out.println("enter id");
				int id_1 = sc.nextInt();
				System.out.println("enter new username");
				String new_user = sc.next();
				user.setId(id_1);
				user.setUsername(new_user);
				dao.updateUser(user);
				break;
			case 2:
				System.out.println("enter id");
				int id_2 = sc.nextInt();
				System.out.println("enter new password");
				String new_password = sc.next();
				user.setId(id_2);
				user.setPassword(new_password);
				dao.updateUser(user);
				break;
			case 3:
				System.out.println("enter id");
				int id_3 = sc.nextInt();
				System.out.println("enter new email");
				String new_email = sc.next();
				user.setId(id_3);
				user.setEmail(new_email);
				dao.updateUser(user);
				break;
			case 4:
				System.out.println("enter id");
				int id_4 = sc.nextInt();
				System.out.println("enter new phono");
				long new_phono = sc.nextLong();
				user.setId(id_4);
				user.setPhono(new_phono);
				dao.updateUser(user);
				break;

			}
		case 6:
			System.out.println("enter email");
			String email1 = sc.next();
			System.out.println("enter password");
			String password1 = sc.next();
            dao.findUserByEmailOrPassword(email1, password1);
		}

	}
}
