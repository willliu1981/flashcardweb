package idv.kwl.model;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {
	private static List<User> defaultUsers = new ArrayList<>();

	public static void initializeDefaultUsers() {
		User u1 = new User();
		u1.setUid("u_1001");
		u1.setName("Kevin");
		u1.setUsername("k1001");
		u1.setPassword("k1234");
		defaultUsers.add(u1);

		User u2 = new User();
		u2.setUid("u_1002");
		u2.setName("John");
		u2.setUsername("j1002");
		u2.setPassword("j1234");
		defaultUsers.add(u2);
	}

	public static User getUser(String id) {
		return defaultUsers.stream().filter(x -> x.getUid().equals(id)).findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public static void update(String id, User user) {
		User u = getUser(id);
		u = user;
	}

	public static boolean delete(String uid) {
	return 	defaultUsers.removeIf(x -> x.getUid().equals(uid));
	}

}
