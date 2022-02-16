package test1;

import test1.concrete.AgeGtMoneyGtProcessor;
import test1.concrete.AgeGtMoneyLtProcessor;
import test1.concrete.AgeLtMoneyGtProcessor;
import test1.concrete.AgeLtMoneyLtProcessor;

public class ResponsibilityDemo {

	public static void main(String[] args) {

		UserPorcessorBuilder builder = UserPorcessorBuilder.instance();
		AgeLtMoneyLtProcessor ageLtMoneyLtProcessor = new AgeLtMoneyLtProcessor();
		AgeGtMoneyLtProcessor ageGtMoneyLtProcessor = new AgeGtMoneyLtProcessor();
		AgeGtMoneyGtProcessor ageGtMoneyGtProcessor = new AgeGtMoneyGtProcessor();
		AgeLtMoneyGtProcessor ageLtMoneyGtProcessor = new AgeLtMoneyGtProcessor();

		builder.addProcessor(ageLtMoneyLtProcessor)
				.addNextProcessor(ageGtMoneyLtProcessor)
				.addNextProcessor(ageGtMoneyGtProcessor)
				.addNextProcessor(ageLtMoneyGtProcessor);

		builder.getProcessors().forEach(System.out::println);
	}

}
