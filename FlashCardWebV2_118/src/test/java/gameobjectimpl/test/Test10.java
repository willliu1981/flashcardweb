package gameobjectimpl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import gameobjectimpl.component.Component;
import idv.tool.Debug;

@ExtendWith(MockitoExtension.class)
public class Test10 {
	@Mock
	Car car1;

	@Test
	public void test1() {
		List<Component> lists = new ArrayList<>();
		Component c1 = new Component();
		c1.setName("comp 1");
		lists.add(c1);

		//		Mockito.when( new Scene().getSceneComponents()).thenReturn(lists);
		Mockito.when(car1.getName()).thenReturn("car 1");

		//List<Component> sceneComponents = Scene.getSceneComponents();
		//sceneComponents.forEach(Debug::test);

		Debug.test(car1.getName());

	}

}
