package List;

import Interface.StackInteface;

public class Stack<E> implements StackInteface<E>{
	private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기 
	private static final Object[] EMPTY_ARRAY = {};	// 빈 배열 

	private Object[] array;	// 요소를 담을 배열  
	private int size;	// 요소 개수 
	
	
	// 생성자1 (초기 공간 할당 X) 
	public Stack() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
	}
	
	// 생성자2 (초기 공간 할당 O) 
	public Stack(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}

	@Override
	public E push(E item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int search(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}
}
