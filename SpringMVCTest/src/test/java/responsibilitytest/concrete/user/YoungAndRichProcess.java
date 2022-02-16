package responsibilitytest.concrete.user;

import idv.kwl.model.User;
import responsibilitytest.concrete.user.UserProcessor.State;

public class YoungAndRichProcess extends UserProcess {

	@Override
	public boolean process(User t) {
		boolean res = t.getAge() < 30 && t.getMoney() >= 1000000;
		if (res) {
			this.setState(State.YoungRich);
		}
		return res;
	}

}
