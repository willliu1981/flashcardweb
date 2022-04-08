package gameobjectimpl.test;

import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;

import gameobjectimpl.animator.Animator;
import idv.tool.Debug;

public class Test9 {

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();

		prop.load(Test9.class.getResourceAsStream("test.properties"));
		String anmString = prop.getProperty("name");
		
		Gson g=new Gson();
		Animator anm = g.fromJson(anmString, Animator.class);
Debug.test(anm.getName(),anm.getCurrentKeyIndex());
anm.getKeyFrames().forEach(x->Debug.test(x.getKeyName(),x.getKeyIndex(),x.getPosition()));
		
		
	}

}
