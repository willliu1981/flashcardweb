package responsibilitytest;

import responsibilitytest.concrete.DefaultProcess;
import responsibilitytest.concrete.ElderAndRichProcess;
import responsibilitytest.concrete.UserProcess;
import responsibilitytest.concrete.YoungAndRichProcess;
import responsibilitytest.process.ProcessorBuilder;

public class RresponsibilityDemo {

	public static void main(String[] args) {

		ProcessorBuilder builder = ProcessorBuilder.instance();
		UserProcess youngAndRichProcess = new YoungAndRichProcess();
		UserProcess elderAndRichProcess = new ElderAndRichProcess();
		UserProcess defaultProcess = new DefaultProcess();

		builder.addProcess(youngAndRichProcess).addProcess(elderAndRichProcess)
				.addProcess(defaultProcess);
		
		UserProcess processor=builder.getFirstProcess();
	}

}
