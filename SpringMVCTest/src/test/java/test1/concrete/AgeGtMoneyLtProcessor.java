package test1.concrete;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;
import test1.AbsProcessor;
import test1.IProcess;

public class AgeGtMoneyLtProcessor extends AbsProcessor {

	@Override
	public List<User> process(List<User> t) {
		List<User> users = UserFactory.getAll();
		return users.stream().filter(x -> x.getAge() >= 25 && x.getMoney() < 10000)
				.collect(Collectors.toList());

	}

}
