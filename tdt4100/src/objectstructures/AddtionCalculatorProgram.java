package objectstructures;

public class AddtionCalculatorProgram {
	
	AdditionCalculator additionCalculator;
	
	public void init() {
		additionCalculator = new AdditionCalculator();
	}
	
	public void run() {
		additionCalculator.setFirstOperand(1.0);
		additionCalculator.setSecondOperand(2.0);
		System.out.println(additionCalculator);
//		double result = additionCalculator.calculateResult();
//		System.out.println(result);
	}
	
	public static void main(String[] args) {
		AddtionCalculatorProgram acp = new AddtionCalculatorProgram();
		acp.init();
		acp.run();
	}	
}
