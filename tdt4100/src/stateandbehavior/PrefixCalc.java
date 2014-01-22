package stateandbehavior;

import java.util.ArrayList;

public class PrefixCalc {

	ArrayList<Double> queue;
	
	public PrefixCalc() {
		queue = new ArrayList<Double>();
	}
	
	public void push(double d) {
		queue.add(queue.size(), d);
	}
	
	public double pop() {
		double d = queue.get(0);
		queue.remove(0);
		return d;
	}
	
	public double peek(int index) {
		return queue.get(0);
	}
	
	public int getSize() {
		return queue.size();
	}
	
	public String toString() {
		return queue.toString();
	} 
	
	public void performOperation() {
		double d1 = pop();
		double d2 = pop();
		push(d1+d2);
	}
	
	public static void main(String[] args) {
		PrefixCalc pc = new PrefixCalc();
		pc.push(1.0);
		pc.push(2.0);
		pc.push(3.0);
		pc.push(4.0);
		System.out.println(pc);
		pc.performOperation();
		pc.performOperation();
		pc.performOperation();
		System.out.println(pc);
	}
}
