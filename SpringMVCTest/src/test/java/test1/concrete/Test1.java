package test1.concrete;

import java.util.List;
import java.util.stream.Collectors;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;

public class Test1 {

	public static void main(String[] args) {
		List<User> users = UserFactory.getAll();

		List<User> newUsers = users.stream().filter(x -> x.getAge() > 100)
				.collect(Collectors.toList());
		System.out.println(newUsers.isEmpty());
	}

}
