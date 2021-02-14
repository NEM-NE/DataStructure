package List;

import java.util.Arrays;
import java.util.EmptyStackException;

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
	
	private void resize() {
		if(this.size == this.array.length) {	// expand array.lengt * 2
			Object[] newArray = new Object[this.array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			this.array = newArray;
		}
		
		if(this.size < this.array.length / 2) {
			Object[] newArray = new Object[this.array.length / 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			this.array = newArray;
		}
		
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
	}
	
	@Override
	public E push(E item) {
		if(this.size == this.array.length) resize();
		array[size] = item;
		
		size++;
		
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		if(this.size == 0) {
			throw new EmptyStackException();
		}
		
		E item = (E) array[size-1];
		array[size-1] = null;
		
		size--;
		resize();
		
		return item;
	}

	@Override
	public E peek() {
		if(this.size == 0) {
			throw new EmptyStackException();
		}
		
		return (E) array[size-1];
	}

	@Override
	public int search(Object value) {
		int search = 0;
		
		for(int i = size; i > 0; i--) {
			search++;
			if(array[i-1] == value) {
				return search;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		// 저장되어있던 모든 요소를 null 처리 해준다.
		for(int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
		resize();
	}

	@Override
	public boolean empty() {
		return (size == 0);
	}
}
