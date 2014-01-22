package objectstructures_old;

import java.util.ArrayList;

public class PrefixCalc {
	
public ArrayList<Double> queue;
	
	public PrefixCalc() {
		queue = new ArrayList<Double>();
	}
	
	public void push(double d) {
		queue.add(queue.size(), d);
	}
	
	public double pop() {
		if (queue.size() > 0) {
			double d = queue.get(0);
			queue.remove(0);
			return d;			
		}
		return Double.NaN;
	}
	
	public double peek(int index) {
		if (0 <= index && index <= queue.size()-1) {
			return queue.get(index);			
		}
		return Double.NaN;
	}
	
	public int getSize() {
		return queue.size();
	}
	
	public String toString() {
		return queue.toString();
	}
	
	public void performOperation() {
		if (queue.size() >= 2) {
			double d1 = pop();
			double d2 = pop();
			push(d1+d2);			
		}
	}
	
	public static void main(String[] args) {
		PrefixCalc pc = new PrefixCalc();
		pc.push(1.0);
		pc.push(2.0);
		pc.push(3.0);
		pc.push(4.0);
		System.out.println(pc);
		pc.performOperation();
		System.out.println(pc);
		pc.performOperation();
		System.out.println(pc);
		pc.performOperation();
		System.out.println(pc);
		pc.performOperation();
		System.out.println(pc);
	}
	
}
