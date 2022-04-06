package gameobjectimpl.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.Animator.KeyFrame;
import gameobjectimpl.component.Component;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;
import gameobjectimpl.component.Scene;
import idv.tool.Debug;

public class Animators {
	private static String TESTANIMATORNAME = "person1.walk-right";
	private static final File FILE = new File(
			"c:/test/gameobject/animators.properties");

	private static final String TESTANIMATORSUFFIX = ".walk";

	public static boolean fileIsExist() {
		return FILE.exists();
	}

	public static void createEmptyFile() {
		try {
			FILE.getParentFile().mkdirs();
			FILE.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Animator load(String name) {
		Properties prop = new Properties();
		try {
			if (!FILE.exists()) {
				prop.load(new FileInputStream(FILE));
			} else {
				prop.load(new FileInputStream(
						"gameobjectimpl.demo.data.defaultdata.animators.properties"));
			}

			Gson gson = new Gson();
			String jsonString = prop.getProperty(name + TESTANIMATORSUFFIX);

			return gson.fromJson(jsonString, Animator.class);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void write(Animator animator, String name) {
		Properties prop = new Properties();

		try {
			if (!FILE.exists()) {
				FILE.getParentFile().mkdirs();
				FILE.createNewFile();
			}

			prop.load(new FileInputStream(FILE));
			Gson gson = new Gson();
			String jsonString = gson.toJson(animator);

			prop.setProperty(name + TESTANIMATORSUFFIX, jsonString);
			prop.store(new FileOutputStream(FILE), "animator");

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void reset() {
		if (FILE.exists()) {
			FILE.delete();
		}
	}

	private static Animator getDefaultAnimator(String name) {

		List<Component> findComponents = GameObjectScanner
				.findComponents((GameObject) Scene.findSceneComponent(name));
		Animator anm = new Animator();

		anm.setMaxNumberOfKey(0);
		findComponents.stream().forEach(comp -> {
			KeyFrame key = new KeyFrame();
			key.setKeyName(comp.getName());
			key.setKeyIndex(0);
			key.setPosition(comp.getRelevantPosition());

			anm.addKeyFrame(key);
		});

		return anm;
	}

	public static KeyFrame findKey(Animator anm, String keyName) {
		Optional<KeyFrame> findAny = anm.getKeyFrames().stream()
				.filter(key -> key.getKeyName().equals(keyName)).findAny();
		if (findAny.isPresent()) {
			return findAny.get();
		}

		return null;
	}

	public static void setPosture(HasAnimation target, Integer keyIndex) {
		List<KeyFrame> findKeys = findKeys(target.getAnimator(TESTANIMATORNAME),
				keyIndex);

		GameObject go = (GameObject) target;
		List<Component> findActivedGameObjectByOwner = Scene
				.findActivedGameObjectByOwner(go.getOwner());
		findKeys.stream().forEach(key -> {
			Optional<Component> findFirst = findActivedGameObjectByOwner.stream()
					.filter(g -> g.getName().equals(key.getKeyName())).findFirst();
			if (findFirst.isPresent()) {
				Component component = findFirst.get();
				component.setRelevantPosition(key.getPosition());
			}
		});

	}

	public static List<KeyFrame> findKeys(Animator anm, Integer keyIndex) {

		return anm.getKeyFrames().stream()
				.filter(key -> key.getKeyIndex().equals(keyIndex))
				.collect(Collectors.toList());
	}

}
