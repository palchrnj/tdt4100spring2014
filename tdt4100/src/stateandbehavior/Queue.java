package stateandbehavior;

import java.util.ArrayList;

public class Queue {
	
	ArrayList<String> queue;
	
	public Queue() {
		queue = new ArrayList<>();
	}
	
	public void push(String str) {
		queue.add(queue.size(), str);
	}
	
	public String pop() {
		String str = queue.get(0);
		queue.remove(0);
		return str;
	}
	
	public String peek(int index) {
		return queue.get(0);
	}
	
	public int getSize() {
		return queue.size();
	}
	
	public String toString() {
		return queue.toString();
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.push("First");
		System.out.println(q);
		q.push("Second");
		System.out.println(q);
		q.push("Third");
		System.out.println(q);
		System.out.println(q.pop());
		System.out.println(q);
	}
}
