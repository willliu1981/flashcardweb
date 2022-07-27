package idv.fc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication 
//@SpringBootApplication(scanBasePackages = "idv.fc")
public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication
				.run(MainApp.class, args);
		
		/*		String[] beanDefinitionNames = run.getBeanDefinitionNames();
				for (String name : beanDefinitionNames) {
					System.out.println(name);
				}*/

	}
}
