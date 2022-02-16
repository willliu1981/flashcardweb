package test1;

import java.util.List;

import idv.kwl.model.User;
import test1.UserPorcessorBuilder.Model;

public class UserModel extends Model<List<User>> {
	private static final String defaultName = "default";

	public void setObject(List<User> list) {
		this.addObject(defaultName, list);
	}

	public List<User> getObject() {
		return this.get(defaultName);
	}
}
