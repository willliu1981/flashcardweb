package responsibilitytest.concrete.director;

import responsibilitytest.process.Process;
import responsibilitytest.process.ProcessBuilder.Processor;

public class Lv1Process extends Process<Integer, Processor<Integer>> {

	@Override
	public boolean process(Integer t) {
		boolean res = t.intValue() < 5000;
		this.getProcessor().setObject("Lv1");
		return res;
	}



}
