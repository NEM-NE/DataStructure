package Queue;

import java.util.NoSuchElementException;

import Interface.Queue;

public class ArrayDeque<E> implements Queue<E>{
	 
	private static final int DEFAULT_CAPACITY = 64; // 최소(기본) 용적 크기
 
	private Object[] array; // 요소를 담을 배열
	private int size; // 요소 개수
 
	private int front; // 시작 인덱스를 가리키는 변수(빈 공간임을 유의)
	private int rear; // 마지막 요소의 인덱스를 가리키는 변수
 
	// 생성자1 (초기 용적 할당을 안할 경우)
	public ArrayDeque() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
 
	// 생성자2 (초기 용적 할당을 할 경우)
	public ArrayDeque(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}

	private void resize(int newCapacity) {
		Object[] newArray = new Object[newCapacity];
		
		for(int i = 0, j = front + 1; i < array.length; i++, j++) {
			newArray[i] = array[j % array.length];
		}
		
		this.array = null;
		this.array = newArray;
		
		front = 0;
		rear = size;

	}
	
	@Override
	public boolean offer(E e) {
		if(size == array.length) resize(array.length * 2);
		rear = (rear + 1) % array.length;
		
		array[rear] = e;
		
		size++;
		
		return true;
	}
	
	public boolean offerLast(E e) {
		return offer(e);
	}
	
	public boolean offerFirst(E e) {
		if(size == array.length) resize(array.length * 2);
		array[front] = e;
		
		front = (front + array.length - 1) % array.length;
		
		size++;
		
		return true;
	}

	@Override
	public E poll() {
		if(size == 0) return null;
		front = (front + 1) % array.length;
		
		E e = (E) array[front];
		array[front] = null;
	
		size--;
		
		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
		if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
				
			// 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다. 
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
		
		return e;
	}
	
	public E pollFirst() {
		return poll();
	}
	
	public E pollLast() {
		if(size == 0) return null;
		
		E e = (E) array[rear];
		array[rear] = null;
		rear = (rear - 1 + array.length) % array.length;
		size--;
		
		// 용적이 최소 크기(64)보다 크고 요소 개수가 1/4 미만일 경우
		if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
				
			// 아무리 작아도 최소용적 미만으로 줄이지는 않도록 한다. 
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
		
		return e;
	}
	
	public E remove() {
		return removeFirst();
	}
	
	public E removeFirst() {
		E e = poll();
		
		if( e == null) {
			throw new NoSuchElementException();
		}
		
		return e;
	}
	
	public E removeLast() {
		E e = pollLast();
		
		if( e == null) {
			throw new NoSuchElementException();
		}
		
		return e;
	}
	
	@Override
	public E peek() {
		if(size == 0) return null;
		return (E) array[(front + 1) % array.length];
	}
	
	public E peekFirst() {
		return peek();
	}
	
	public E peekLast() {
		if(size == 0) return null;
		return (E) array[rear];
	}
	
	public E element() {
		return getFirst();
	}
	
	public E getFirst() {
		E e = peekFirst();
		if(e == null) throw new NoSuchElementException();
		
		return e;
	}
	
	public E getLast() {
		E e = peekLast();
		if(e == null) throw new NoSuchElementException();
		
		return e;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean clear() {
		
		for(int i = 0; i < array.length; i++) {
			array[i] = null;
		}
		
		front = rear = size = 0;
		
		return true;
	}
	
	public boolean contains(Object value) {
		for(int start = front + 1; start == rear; start = (start + 1) % array.length) {
			if(value.equals(array[start])) {
				return true;
			}
		}
		return false;
	}
}
