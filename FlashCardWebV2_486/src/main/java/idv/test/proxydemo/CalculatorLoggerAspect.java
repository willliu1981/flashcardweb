package idv.test.proxydemo;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("calculatorLoggerAspect")
@Aspect
public class CalculatorLoggerAspect {

	@Before("execution(public double idv.test.proxydemo.CircleCalculator.calcArea(int...))")
	public void beforeMethod() {
		System.out.println("before...");
	}
}
