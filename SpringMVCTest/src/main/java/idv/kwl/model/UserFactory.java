package idv.kwl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserFactory {
	private static List<User> defaultUsers = new ArrayList<>();

	public static void initializeDefaultUsers() {
		User u1 = new User();
		u1.setUid("u_1001");
		u1.setName("Kevin");
		u1.setUsername("k1001");
		u1.setPassword("k1234");
		u1.setAge(52);
		u1.setMoney(8000000);
		defaultUsers.add(u1);

		User u2 = new User();
		u2.setUid("u_1002");
		u2.setName("John");
		u2.setUsername("j1002");
		u2.setPassword("j1234");
		u2.setAge(26);
		u2.setMoney(1700000);
		defaultUsers.add(u2);

		User u3 = new User();
		u3.setUid("u_1011");
		u3.setName("John11");
		u3.setUsername("j1011");
		u3.setPassword("j1234");
		u3.setAge(25);
		u3.setMoney(12000);
		defaultUsers.add(u3);

		User u4 = new User();
		u4.setUid("u_1012");
		u4.setName("John12");
		u4.setUsername("j1014");
		u4.setPassword("j1234");
		u4.setAge(23);
		u4.setMoney(13500);
		defaultUsers.add(u4);
	}

	public static User login(String username, String password) {
		Optional<User> userOP = defaultUsers.stream()
				.filter(x -> x.getUsername().equals(username)
						&& x.getPassword().equals(password))
				.findFirst();
		if (userOP.isPresent()) {
			return userOP.get();
		}
		return null;
	}

	public static boolean add(User user) {
		boolean res = true;
		try {
			getUserByID(user.getUid());
			res = false;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		try {
			getUserByUsername(user.getUsername());
			res = false;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		if (res) {
			defaultUsers.add(user);
		}
		return res;
	}

	public static User getUserByID(String id) {
		return defaultUsers.stream().filter(x -> x.getUid().equals(id)).findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public static User getUserByUsername(String username) {
		return defaultUsers.stream().filter(x -> x.getUsername().equals(username))
				.findFirst().orElseThrow(RuntimeException::new);
	}

	public static void update(String id, User user) {
		User u = getUserByID(id);
		u = user;
	}

	public static boolean delete(String uid) {
		return defaultUsers.removeIf(x -> x.getUid().equals(uid));
	}

	public static List<User> getAll() {
		return defaultUsers;
	}

}
