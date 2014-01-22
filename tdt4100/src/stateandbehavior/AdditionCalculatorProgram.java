package stateandbehavior;

public class AdditionCalculatorProgram {
	
	AdditionCalculator ac;
	
	public void init() {
		ac = new AdditionCalculator();
	}
	
	public void run() {
		ac.setFirstOperand(2.0);
		ac.setSecondOperand(3.0);
		System.out.println(ac.calculateResult());
	}
	
	public static void main(String[] args) {
		AdditionCalculatorProgram acp = new AdditionCalculatorProgram();
		acp.init();
		acp.run();
	}
}
