package responsibilitytest.concrete;

import idv.kwl.model.User;
import responsibilitytest.concrete.UserProcessor.State;

public class ElderAndRichProcess extends UserProcess {

	@Override
	public boolean process(User t) {
		boolean res = t.getAge() >= 50 && t.getMoney() >= 5000000;
		if (res) {
			this.setState(State.ElderRich	);
		}
		return res;
	}

}
