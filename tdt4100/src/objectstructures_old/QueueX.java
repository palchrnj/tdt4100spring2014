package objectstructures_old;

import java.util.ArrayList;

public class QueueX {
	
	public ArrayList<String> queue;
	
	public QueueX() {
		queue = new ArrayList<String>();
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
		return queue.get(index);
	}
	public int getSize() {
		return queue.size();
	}
	
	public String toString() {
		return queue.toString();
	}
	
	public static void main(String[] args) {
		QueueX q = new QueueX();
		q.push("First");
		q.push("Second");
		q.push("Third");
		q.push("Fourth");
		System.out.println(q);
		q.pop();
		q.pop();
		System.out.println(q);
	}
}