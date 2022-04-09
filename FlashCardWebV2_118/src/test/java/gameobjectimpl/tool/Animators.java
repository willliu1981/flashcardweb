package gameobjectimpl.tool;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.Animator.KeyFrame;
import gameobjectimpl.animator.AnimatorControl;
import gameobjectimpl.component.Component;
import gameobjectimpl.component.GameObject;
import gameobjectimpl.component.HasAnimation;
import gameobjectimpl.component.Scene;
import idv.tool.Debug;

public class Animators {
	private static final File FILE = new File(
			"c:/test/gameobject/animators.properties");

	private static final String PROP_KEY_RPREFIX = "animator";
	private static final String SPINE = "spine";
	private static final String ROOT = "person1";

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

	public static List<String> getAnimatorNames(HasAnimation target) {
		return target.getAnimators().keySet().stream().collect(Collectors.toList());
	}

	public static void writeAll(HasAnimation target, String ownerName) {
		//fixNamesInAnimator(target);//檔案損毀時的解決方案
		target.getAnimators().values().stream().forEach(anm -> {
			write(anm, ownerName);
		});
	}

	public static void write(Animator animator, String ownerName) {
		Properties prop = new Properties();

		try {
			if (!FILE.exists()) {
				FILE.getParentFile().mkdirs();
				FILE.createNewFile();
			}

			prop.load(new FileInputStream(FILE));
			Gson gson = new Gson();
			String jsonString = gson.toJson(animator);

			String propKey = String.format("%s.%s.%s", PROP_KEY_RPREFIX,
					ownerName.trim(), animator.getName().trim());
			prop.setProperty(propKey, jsonString);
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

	public static void setPosture(String owner, Animator animator, Integer keyIndex) {

		List<KeyFrame> findKeys = findKeysByIndex(animator, keyIndex);

		List<Component> findActivedGameObjectByOwner = Scene
				.findActivedGameObjectByOwner(owner);
		findKeys.stream().forEach(key -> {
			Optional<Component> findFirst = findActivedGameObjectByOwner.stream()
					.filter(g -> g.getName().equals(key.getKeyName())).findFirst();
			if (findFirst.isPresent()) {
				Component component = findFirst.get();
				component.setRelevantPosition(key.getPosition());
			}
		});
	}

	public static void setPosture(HasAnimation target, String animatorName,
			Integer keyIndex) {
		setPosture(((GameObject) target).getOwner(), target.getAnimator(animatorName),
				keyIndex);

	}

	public static List<KeyFrame> findKeysByIndex(Animator anm, Integer keyIndex) {

		return anm.getKeyFrames().stream()
				.filter(key -> key.getKeyIndex().equals(keyIndex))
				.collect(Collectors.toList());
	}

	public static KeyFrame findKeysByEqualWithKey(Animator anm, KeyFrame key) {

		Optional<KeyFrame> findKey = anm.getKeyFrames().stream().filter(k -> {

			return k.equals(key);
		}).findFirst();

		if (findKey.isPresent()) {
			return findKey.get();
		}

		return null;
	}

	public static void reverseKeys(Animator reverse, Animator target) {
		KeyFrame spine = new KeyFrame();
		spine.setKeyName(SPINE);
		spine.setKeyIndex(0);
		KeyFrame findSpine = findKeysByEqualWithKey(target, spine);
		if (findSpine != null) {
			reverse.setMaxNumberOfKey(target.getMaxNumberOfKey());
			reverse.setName(reverse.getName());
			reverse.setCurrentKeyIndex(0);

			reverse.setKeyFrames(new ArrayList<>());
			target.getKeyFrames().forEach(key -> {
				KeyFrame newKey = new KeyFrame();
				newKey.setKeyName(key.getKeyName());
				newKey.setKeyIndex(key.getKeyIndex());

				Point targetPos = key.getPosition();
				Point spinePos = findSpine.getPosition();
				Point newPos = new Point();
				int relX = targetPos.x - spinePos.x;

				newPos.x = spinePos.x - relX;
				newPos.y = targetPos.y;

				if (key.getKeyName().endsWith(ROOT)) {
					newKey.setPosition(key.getPosition());
				} else {
					newKey.setPosition(newPos);
				}
				reverse.addKeyFrame(newKey);

			});
		}

	}

	public static void fixNamesInAnimator(HasAnimation target) {

		target.getAnimators().values().forEach(anm -> {

			String name = anm.getName().replaceAll("\"", "");
			anm.setName(name);

			anm.getKeyFrames().forEach(key -> {
				String keyName = key.getKeyName().replaceAll("\"", "");
				key.setKeyName(keyName);
			});

		});

	}

	public static void animatorTick(AnimatorControl control) {

		Animator activeAnimator = control.getCurrentAnimator();
		int maxKey = activeAnimator.getMaxNumberOfKey();
		Integer currentKeyIndex = control.getCurrentKeyIndex(activeAnimator.getName());
		Animators.setPosture(control.getOwner().getOwner(), activeAnimator,
				currentKeyIndex);

		currentKeyIndex++;
		if (currentKeyIndex > maxKey) {
			currentKeyIndex = 0;
		}
		control.setCurrentKeyIndex(activeAnimator.getName(), currentKeyIndex);

	}

}
