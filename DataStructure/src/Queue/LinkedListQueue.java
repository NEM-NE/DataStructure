package Queue;

import java.util.NoSuchElementException;

import Interface.Queue;
import List.SNode;
import Queue.Node;

public class LinkedListQueue<E> implements Queue<E> {
	 
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedListQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean offer(E e) {
		Node<E> newNode = new Node<E>(e);
		
		if(size == 0) {
			head = newNode;
		}else {
			tail.next = newNode;
		}
		
		tail = newNode;
		size++;
		
		return true;
	}

	@Override
	public E poll() {		
		if(size == 0) {
			return null;
		}
		
		E e = head.data;
		
		Node<E> next = head.next;
		head = null;
		head = next;
		
		size--;
		
		return e;
	}

	public E remove() {
		E e = poll();
		
		if(e == null) {
			throw new NoSuchElementException();
		}
		
		return e;
	}
	
	@Override
	public E peek() {
		if(size == 0) {
			return null;
		}
		
		return head.data;
	}
	
	public E element() {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		return head.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		Node<E> x = head;
		
		for(; x != null;) {
			Node<E> next = x.next;
			x.data = null;
			x.next = null;
			
			x = next;
		}
		
		head = tail = null;
		size = 0;
	}
	
	public boolean contains(Object value) {
		
		
		return false;
	}
}
