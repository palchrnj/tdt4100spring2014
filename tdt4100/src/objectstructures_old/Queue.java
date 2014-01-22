package objectstructures_old;

import java.util.ArrayList;

public class Queue {
	
	public ArrayList<String> list;
	
	public Queue() {
		list = new ArrayList<String>();
	}
	
	public void push(String str) {
		list.add(list.size(), str);
	}
	
	public String pop() {
		String str = list.get(0);
		list.remove(0);
		return str;
	}
	
	public String peek(int index) {
		return list.get(index);
	}
	
	public int getSize() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.push("First");
		q.push("Second");
		q.push("Third");
		System.out.println(q);
		System.out.println(q.pop());
		System.out.println(q);
		q.push("Fourth");
		System.out.println(q);
	}
	
}
