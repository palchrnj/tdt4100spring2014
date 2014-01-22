package objectstructures;

public class AdditionCalculator {
	
	public double firstOperand;
	public double secondOperand;
	public char operator;
	
	public AdditionCalculator() {
		firstOperand = Double.NaN;
		secondOperand = Double.NaN;
		operator = '+';
	}

	public void setFirstOperand(double firstOperand) {
		this.firstOperand = firstOperand;
	}

	public void setSecondOperand(double secondOperand) {
		this.secondOperand = secondOperand;
	}
	
	public double calculateResult() {
		if (firstOperand != Double.NaN && secondOperand != Double.NaN && operator == '+') {
			return firstOperand + secondOperand;
		} else {
			return Double.NaN;
		}
	}
	
	public String toString() {
		return "[" + firstOperand + " " + operator + " " + secondOperand + " = " + calculateResult() + "]";
	}
	
	public static void main(String[] args) {
		AdditionCalculator additionCalculator = new AdditionCalculator();
		additionCalculator.setFirstOperand(1.0);
		additionCalculator.setSecondOperand(2.0);
		System.out.println(additionCalculator);
	}
}
