package idv.test.proxydemo;

public class RectangleCalculator implements GraphCalculatorI {

	@Override
	public double calcArea(int... param) {

		double area = param[0] * param[1];

		return area;
	}

	@Override
	public int clacPerimeter(int... param) {
		int perimeter = (param[0] + param[1]) * 2;
		return perimeter;
	}

}
