package gameobjectimpl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import gameobjectimpl.component.Component;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Body;
import gameobjectimpl.component.impl.HasScript;
import gameobjectimpl.component.impl.Person;
import idv.tool.Debug;

@ExtendWith(MockitoExtension.class)
public class Test10 {
	@Mock
	static Car car1;

	@Mock
	Scene sc;

	@Mock
	Component c3;

	public static List<Component> lists = new ArrayList<>();

	@BeforeAll
	public static void before() {
		Component c1 = new Component();
		c1.setName("comp 1");
		lists.add(c1);

		Component c2 = new Person();
		c2.setName("comp 2");
		lists.add(c2);

		Component c3 = new Body();
		c3.setName("comp 3");
		lists.add(c3);
		Debug.test("before all(lists size)", lists.size());
	}

	public void template() {
		//*
		try (MockedStatic<?> utilities = Mockito.mockStatic(Class.class)) {
			utilities.when(null).thenReturn(null);
			

		} //*/
	}

	@Disabled
	@Test
	public void test1() {
		Mockito.when(car1.getName()).thenReturn("xxx");
		Debug.test("test1", car1.getComponents());

	}

	@Disabled
	@Test
	public void test2() {
		List<Component> lists = new ArrayList<>();
		Component c1 = new Component();
		c1.setName("comp 1");
		lists.add(c1);

		Component c2 = new Person();
		c2.setName("comp 2");
		lists.add(c2);

		c3.setName("comp 3");
		lists.add(c3);

		List<Component> sceneComponents;
		List<HasScript> sceneComponentsWithScript;
		try (MockedStatic<Scene> utilities = Mockito.mockStatic(Scene.class)) {
			utilities.when(Scene::getSceneComponents).thenReturn(lists);

			//*
			sceneComponents = Scene.getSceneComponents();
			Debug.test(this, "size", sceneComponents.size());
			List<HasScript> hses = sceneComponents.stream().filter(comp -> {
				Debug.test(this, comp.getName(), comp instanceof HasScript);
				return comp instanceof HasScript;
			}).map(comp2 -> {
				HasScript hs = (HasScript) comp2;
				return hs;
			}).collect(Collectors.toList());

			Debug.test(this, "find", hses);//*/

		}

		Debug.test("final");
		sceneComponentsWithScript = Scene.getSceneComponentsWithScript();
		Debug.test("size", sceneComponentsWithScript.size());
		sceneComponentsWithScript.forEach(x -> Debug.test(this, x));
	}

	@Disabled
	@Test
	public void test3() {
		List<Component> lists = new ArrayList<>();
		Component c1 = new Component();
		c1.setName("comp 1");
		lists.add(c1);

		Component c2 = new Person();
		c2.setName("comp 2");
		lists.add(c2);

		Component c3 = new Person();
		c3.setName("comp 3");
		lists.add(c3);

		try (MockedStatic<Scene> utilities = Mockito.mockStatic(Scene.class)) {
			List<HasScript> sceneComponentsWithScript;
			utilities.when(Scene::getSceneComponents).thenReturn(lists);

			List<Component> sceneComponents = Scene.getSceneComponents();
			Debug.test("test3 sceneComponents", sceneComponents.size());

			Debug.test("final");

			sceneComponentsWithScript = Scene.getSceneComponentsWithScript();
			Debug.test("size", sceneComponentsWithScript.size());
			sceneComponentsWithScript.forEach(x -> Debug.test(this, x));
		}
	}

	@Test
	public void test4() {
		Debug.test("test4");
		List<HasScript> sceneComponentsWithScript;
		sceneComponentsWithScript = Scene.getSceneComponentsWithScript();
		sceneComponentsWithScript.forEach(x -> Debug.test(this, x));
		

	}

}
