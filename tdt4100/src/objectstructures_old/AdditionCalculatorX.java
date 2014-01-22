package objectstructures_old;

public class AdditionCalculatorX {
	
	public double firstOperand;
	public double secondOperand;
	public double operator;
	
	public AdditionCalculatorX() {
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
		if (firstOperand != Double.NaN && secondOperand != Double.NaN && operator == '+') {
			return "[" + firstOperand + " + " + secondOperand + " = " + calculateResult() + "]";
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		AdditionCalculatorX acx = new AdditionCalculatorX();
		acx.setFirstOperand(1.0);
		acx.setSecondOperand(2.0);
		System.out.println(acx);
	}
}
