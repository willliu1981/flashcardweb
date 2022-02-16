package responsibilitytest;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;
import responsibilitytest.concrete.user.DefaultProcess;
import responsibilitytest.concrete.user.ElderAndRichProcess;
import responsibilitytest.concrete.user.UserProcess;
import responsibilitytest.concrete.user.UserProcessor;
import responsibilitytest.concrete.user.YoungAndRichProcess;
import responsibilitytest.concrete.user.UserProcessor.State;
import responsibilitytest.process.ProcessBuilder;

public class RresponsibilityDemo {

	public static void main(String[] args) {

		ProcessBuilder builder = ProcessBuilder.instance();
		builder.addProcess(new YoungAndRichProcess())
				.addProcess(new ElderAndRichProcess()).addProcess(new DefaultProcess());

		UserProcessor processor = new UserProcessor(builder);

		UserFactory.initializeDefaultUsers();
		User user = UserFactory.getUserByID("u_1002");

		processor.process(user);

		State state = processor.getState();

		System.out.println(state);

	}

}
