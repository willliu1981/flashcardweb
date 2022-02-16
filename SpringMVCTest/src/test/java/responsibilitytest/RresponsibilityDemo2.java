package responsibilitytest;

import responsibilitytest.concrete.director.Lv1Process;
import responsibilitytest.concrete.director.Lv2Process;
import responsibilitytest.concrete.director.Lv3Process;
import responsibilitytest.concrete.director.Lv4Process;
import responsibilitytest.process.ProcessBuilder;
import responsibilitytest.process.ProcessBuilder.Processor;

public class RresponsibilityDemo2 {

	public static void main(String[] args) {

		ProcessBuilder builder = ProcessBuilder.instance();
		builder.addProcess(new Lv1Process()).addProcess(new Lv2Process())
				.addProcess(new Lv3Process()).addProcess(new Lv4Process());

		Processor<Integer> processor = new Processor<>(builder);
		String res = (String) processor.process(8000);

		System.out.println(res);

	}

}
