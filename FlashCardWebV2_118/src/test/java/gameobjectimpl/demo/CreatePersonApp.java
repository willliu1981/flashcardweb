package gameobjectimpl.demo;

import java.util.List;
import java.util.stream.Collectors;

import gameobjectimpl.animator.Animator;
import gameobjectimpl.animator.Animator.KeyFrame;
import gameobjectimpl.component.Scene;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import gameobjectimpl.gui.PersonCreatorFrame;
import gameobjectimpl.tool.Animators;
import idv.tool.Debug;

public class CreatePersonApp {

	public static void main(String[] args) throws InterruptedException {

		//Person person = Application.getBean("David", Person.class);
		//Scene.addSceneComponent(person);
		//person.addAnimator("walk", Animators.load("David"));
		//Animators.setPosture(person, 0);
		//Scene.locating();

		//PersonCreatorFrame pcf = new PersonCreatorFrame(null);
		//pcf.setVisible(true);

		/*
		List<Animator> activedAnimators = Scene.getActivedAnimators();
		List<List<KeyFrame>> collect = activedAnimators.stream()
				.map(x -> x.getKeyFrames()).collect(Collectors.toList());
		collect.forEach(x -> x.stream()
				.forEach(x2 -> Debug.test(x2.getKeyName(),x2.getKeyIndex(), x2.getPosition())));
		//*/
	}

}
