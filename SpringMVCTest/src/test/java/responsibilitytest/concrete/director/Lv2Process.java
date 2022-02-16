package responsibilitytest.concrete.director;

import responsibilitytest.process.Process;
import responsibilitytest.process.ProcessBuilder.Processor;

public class Lv2Process extends Process<Integer> {
	private Processor processor;

	@Override
	public boolean process(Integer t) {
		boolean res = t.intValue() >= 5000 && t.intValue() < 10000;
		return res;
	}

	@Override
	public void setProcessor(Processor<?> processor) {
		this.processor = processor;
	}

}
