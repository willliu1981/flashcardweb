package gameobjectimpl.tool;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.common.io.Files;
import com.google.gson.Gson;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.Animator.KeyFrame;
import gameobjectimpl.component.Component;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.Scene;
import idv.tool.Debug;

public class Animators {
	private static final File FILE = new File(
			"c:/test/gameobject/person1-animator.properties");

	private static final String PREFIX = "animator.";

	public static Animator load(String name) {
		Properties prop = new Properties();
		try {
			if (!FILE.exists()) {
				FILE.getParentFile().mkdirs();
				FILE.createNewFile();
				Animator animator = getDefaultAnimator(name);
				write(animator, name);
				return animator;
			}
			prop.load(new FileInputStream(FILE));
			Gson gson = new Gson();
			String jsonString = prop.getProperty(PREFIX + name);

			return gson.fromJson(jsonString, Animator.class);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void write(Animator animator, String name) {
		Properties prop = new Properties();
		try {

			prop.load(new FileInputStream(FILE));
			Gson gson = new Gson();
			String jsonString = gson.toJson(animator);

			prop.setProperty(PREFIX + name, jsonString);
			prop.store(new FileOutputStream(FILE), "animator");

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	private static Animator getDefaultAnimator(String name) {

		List<Component> findComponents = GameObjectScanner
				.findComponents((GameObject) Scene.findSceneComponent(name));
		Animator anm = new Animator();

		findComponents.stream().forEach(comp -> {
			KeyFrame key = new KeyFrame();
			key.setKeyName(comp.getName());
			key.setKeyIndex(0);
			key.setPosition(comp.getRelevantPosition());

			anm.addKeyFrame(key);
		});

		return anm;
	}

	@Test
	public void test1() {
		String fileString = "c:/test/animator.properties";
		File file = new File(fileString);

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(file));
			Animator anm = new Animator();
			KeyFrame key = new KeyFrame();
			key.setKeyIndex(1);
			key.setKeyName("spine");
			key.setPosition(new Point(20, 20));
			anm.addKeyFrame(key);

			KeyFrame key2 = new KeyFrame();
			key2.setKeyIndex(1);
			key2.setKeyName("head");
			key2.setPosition(new Point(30, 30));

			anm.addKeyFrame(key2);
			Gson gson = new Gson();
			String jsonString = gson.toJson(anm);

			prop.clear();
			prop.setProperty("person1", jsonString);
			prop.list(System.out);

			prop.store(new FileOutputStream(file.toString()), "person1");

			//Debug.test(prop.getProperty("animator.spine"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test2() {
		String fileString = "c:/test/person1-animator.properties";
		File file = new File(fileString);

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(file));

			Gson gson = new Gson();

			String jsonString = prop.getProperty("person1");

			Animator anm = gson.fromJson(jsonString, Animator.class);

			anm.getKeyFrames().forEach(x -> System.out.println(x.getKeyName()));
			//Debug.test(anm);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
