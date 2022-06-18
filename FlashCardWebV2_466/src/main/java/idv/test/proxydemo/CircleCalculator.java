package idv.test.proxydemo;

import org.springframework.stereotype.Component;

@Component( )
public class CircleCalculator implements GraphCalculatorI {

	@Override
	public int clacPerimeter(int... param) {
		int perimeter = (int) (2 * Math.PI * param[0]);

		return perimeter;
	}

	@Override
	public double calcArea(int... param) {
		double area = Math.PI * param[0] * param[0];

		return area;
	}
	

}
