package gameobjectimpl.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import gameobjectimpl.config.Application;
import idv.tool.Debug;

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();

		/*
		Path base = Paths.get("c:/test");
		Path p1 = Paths.get("person1-animator.properties");
		Path rel = base.relativize(p1);
		Debug.test(rel);
		//*/

		//Path basePath = Paths.get();
		//Path relPath =Paths.get("") ;

		/*
		String pathString=Application.class.getResource("person1-animator.properties").getPath();
		Debug.test(pathString);
		//Path p2=Paths.get(pathString);
		File f=new File(pathString);
		
		
		Debug.test(f.getParent());
		//*/
		String pathString = Test4.class.getResource("")
				.getPath();
		File file = new File(pathString);
		//*
		prop.load(new FileInputStream(
				new File(file.getParent() + "/config/person1-animator.properties")));
		Debug.test(prop.getProperty("animator.spine"));
		//*/
	}

}
