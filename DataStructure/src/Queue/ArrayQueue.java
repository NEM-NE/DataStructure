package Queue;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import Interface.Queue;

public class ArrayQueue<E> implements Queue<E> {

	private static final int DEFAULT_CAPACITY = 64;	// 최소(기본) 용적 크기 
	
	private Object[] array;	// 요소를 담을 배열 
	private int size;	// 요소 개수 
	
	private int front;	// 시작 인덱스를 가리키는 변수(빈 공간임을 유의)
	private int rear;	// 마지막 요소의 인덱스를 가리키는 변수 
	
	
	// 생성자1 (초기 용적 할당을 안할 경우)  
	public ArrayQueue() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	// 생성자2 (초기 용적 할당을 할 경우) 
	public ArrayQueue(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	private void resize(int newCapacity) {
		int arrayCapacity = array.length;
		Object[] newArray = new Object[newCapacity];
		
		for(int i = 1, j = front + 1; i <= size; i++, j++ ) {
			newArray[i] = array[j % arrayCapacity];
		}
		
		this.array = null;
		this.array = newArray;
		
		front = 0;
		rear = size;
	}
	
	@Override
	public boolean offer(E e) {
		// 용적이 가득 찼을 경우 
		if((rear + 1) % array.length == front) {
			resize(array.length * 2);	// 용적을 두 배 늘려준다. 
		}
		
		rear = (rear + 1) % array.length;
		array[rear] = e;
		size++;
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E poll() {
		if(size == 0) {
			return null;
		}
		
		front = (front + 1) % array.length;
		E item = (E) array[front];
		
		size--;
		
		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
		if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
				
			// 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다. 
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
		
		return item;
	}
	
	public E remove() {
		E e = poll();
		
		if(e == null) {
			throw new NoSuchElementException();
		}
		
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if(size == 0) {
			return null;
		}
		
		front = (front + 1) % array.length;
		return (E) array[front];
	}
	
	public E element() {
		E e = peek();
		
		if(e == null) {
			throw new EmptyStackException();
		}
		
		return e;
	}
	
	public boolean contains(Object value) {
		int start = front + 1;
		int end = rear;
		
		while(start == end) {
			start = start % array.length;
			
			if(array[start].equals(value)) return true;
			
			start++;
		}
		
		return false;
	}

}
