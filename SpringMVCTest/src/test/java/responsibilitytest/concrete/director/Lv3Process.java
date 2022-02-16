package responsibilitytest.concrete.director;

import responsibilitytest.process.Process;
import responsibilitytest.process.ProcessBuilder.Processor;

public class Lv3Process extends Process<Integer> {
	private Processor processor;

	@Override
	public boolean process(Integer t) {
		boolean res = t.intValue() >= 10000 && t.intValue() < 100000;
		return res;
	}

	@Override
	public void setProcessor(Processor<?> processor) {
		this.processor = processor;
	}

}
