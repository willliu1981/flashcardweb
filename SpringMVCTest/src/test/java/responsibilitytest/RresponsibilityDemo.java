package responsibilitytest;

import idv.kwl.model.User;
import idv.kwl.model.UserFactory;
import responsibilitytest.concrete.DefaultProcess;
import responsibilitytest.concrete.ElderAndRichProcess;
import responsibilitytest.concrete.UserProcess;
import responsibilitytest.concrete.UserProcessor;
import responsibilitytest.concrete.UserProcessor.State;
import responsibilitytest.concrete.YoungAndRichProcess;
import responsibilitytest.process.ProcessBuilder;

public class RresponsibilityDemo {

	public static void main(String[] args) {

		ProcessBuilder builder = ProcessBuilder.instance();
		UserProcess youngAndRichProcess = new YoungAndRichProcess();
		UserProcess elderAndRichProcess = new ElderAndRichProcess();
		UserProcess defaultProcess = new DefaultProcess();

		builder.addProcess(youngAndRichProcess).addProcess(elderAndRichProcess)
				.addProcess(defaultProcess);

		UserProcessor processor = new UserProcessor(builder);

		UserFactory.initializeDefaultUsers();
		User user = UserFactory.getUserByID("u_1011");

		processor.process(user);

		State state = processor.getState();

		System.out.println(state);

	}

}
