package Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> arrayqueue = new ArrayDeque<>();
		Queue<Integer> linkedList = new LinkedList<>();
		
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < 10000000; i++) {
			arrayqueue.add(1);
		}
		long end1 = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 10000000; i++) {
			linkedList.add(1);
		}
		long end2 = System.currentTimeMillis();

		System.out.println("ArrayQueue : " + (end1 - start1));
		System.out.println("LinkedList : " + (end2 - start2));
		
	}

}
