package gameobjectimpl.test;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.Scene;
import idv.tool.Debug;

@ExtendWith(MockitoExtension.class)
public class Test10 {
	@Mock
	Car car1;
	@Mock
	Scene sc;

	@Disabled
	@Test
	public void test1() {
		/*
		List<Component> lists = new ArrayList<>();
		Component c1 = new Component();
		c1.setName("comp 1");
		lists.add(c1);
		
		Mockito.when(sc.testGetSceneComponents()).thenReturn(lists);
		//Mockito.when(car1.getName()).thenReturn("car 1");
		
		List<Component> sceneComponents = sc.testGetSceneComponents();
		sceneComponents.forEach(Debug::test);
		
		//Debug.test(car1.getName());
		//*/
	}

	@Test
	public void test2() {
		List<Component> lists = new ArrayList<>();
		Component c1 = new Component();
		c1.setName("comp 1");
		lists.add(c1);
		
		try (MockedStatic<Scene> utilities = Mockito.mockStatic(Scene.class)) {
			utilities.when(Scene::getSceneComponents).thenReturn(lists);

			List<Component> sceneComponents = sc.getSceneComponents();
			sceneComponents.forEach(Debug::test);
			//Debug.test(Scene.getLogo());
		}

	}

}
