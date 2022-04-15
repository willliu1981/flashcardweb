package gameobjectimpl.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import gameobjectimpl.control.TestGameController;
import idv.tool.Debug;

@ExtendWith(MockitoExtension.class)
public class Test11 {

	@Test
	public void test1() {

		TestGameController tc = new TestGameController();
		Debug.test(tc.isStarted());
		Debug.test(tc.isStarted());

	}

}
