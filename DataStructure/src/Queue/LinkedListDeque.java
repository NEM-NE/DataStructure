package Queue;

import java.util.NoSuchElementException;

import Interface.Queue;

public class LinkedListDeque<E> implements Queue<E>{

	private Node<E> head; // 가장 앞에 있는 노드를 가리키는 변수
	private Node<E> tail; // 가장 뒤에 있는 노드를 가리키는 변수
	private int size; // 요소(노드)의 개수
	
	public LinkedListDeque() {
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public boolean offer(E e) {
		if(size == 0) return offerFirst(e);
		
		Node<E> newNode = new Node(e);
		newNode.pre = tail;
		tail = newNode;
		size++;
		
		return true;
	}

	public boolean offerFirst(E e) {
		Node<E> newNode = new Node(e);
		newNode.next = head;
		
		//처음 삽입 한 것이 아닐 경우
		if(head != null) {
			head.pre = newNode;	
		}
		
		head = newNode;
		
		size++;
		
		//1개 밖에 없는 경우
		if(head.next == null) {
			tail = head;
		}
		
		return true;
	}
	
	public boolean offerLast(E e) {
		offer(e);
		return true;
	}
	
	@Override
	public E poll() {
		if(size == 0) return null;
		
		E result = head.data;
		head = head.next;
		size--;
		if(size == 0) tail = null;
		return result;
	}
	
	public E pollFirst() {
		return poll();
	}
	
	public E pollLast() {
		if(size == 0) return null;
		
		E result = tail.data;
		tail = null;
		tail = tail.pre;
		size--;
		
		if(size == 0) head = null;
		
		return result;
	}
	
	public E remove() {
		if(size == 0) throw new NoSuchElementException();
		
		E result = head.data;
		head = head.next;
		size--;
		if(size == 0) tail = null;
		
		return result;
	}
	
	public E removeFirst() {
		return remove();
	}
	
	public E removeLast() {
		E element = pollLast();
		
		if(element == null) throw new NoSuchElementException();
		
		return element;
	}

	@Override
	public E peek() {
		if(size == 0) return null;
		
		return head.data;
	}
	
	public E peekFirst() {
		return peek();
	}
	
	public E peekLast() {
		if(size == 0) return null;
		
		return tail.data;
	}
	
	public E get() {
		E element = peek();
		
		if(element == null) throw new NoSuchElementException();
		
		return element;
	}
	
	public E getFirst() {
		return get();
	}
	
	public E getLast() {
		E element = peekLast();
		
		if(element == null) throw new NoSuchElementException();
		
		return element;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(Object e) {
	
		for(Node x = head; x != null; x = x.next) {
			if(x.data.equals(e)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void clear() {
		for(Node x = head; x != null; x = x.next) {
			x.data = null;
			x.pre.next = null;
			x.pre = null;
		}
		
		size = 0;
		head = tail = null;
	}

}
