package stateandbehavior;

public class AdditionCalculator {
	
	public double firstOperand;
	public double secondOperand;
	public char operator;
	
	public AdditionCalculator() {
		firstOperand = Double.NaN;
		secondOperand = Double.NaN;
		operator = '+';
	}
	
	public void setFirstOperand(double operand) {
		firstOperand = operand;
	}

	public void setSecondOperand(double operand) {
		secondOperand = operand;
	}
	
	public double calculateResult() {
		if (firstOperand != Double.NaN && secondOperand != Double.NaN && operator == '+') {
			return firstOperand + secondOperand;
		}
		return Double.NaN;
	}
	
}
