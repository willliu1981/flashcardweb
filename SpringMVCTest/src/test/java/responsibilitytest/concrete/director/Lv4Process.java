package responsibilitytest.concrete.director;

import responsibilitytest.process.Process;
import responsibilitytest.process.ProcessBuilder.Processor;

public class Lv4Process extends Process<Integer, Processor<Integer>> {

	@Override
	public boolean process(Integer t) {
		boolean res = t.intValue() >= 100000;
		this.getProcessor().setObject("Lv4");
		return res;
	}

}
