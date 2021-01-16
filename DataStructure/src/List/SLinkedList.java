package List;

import Interface.Collection;
import Interface.Iterator;
import Interface.List;

public class SLinkedList<E> implements List<E> {
	private Node<E> head;	// 노드의 첫 부분 
	private Node<E> tail;	// 노드의 마지막 부분
	private int size;	// 요소 개수 
	
	// 생성자
	public SLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	private Node<E> search(int index){
		if(index >= size || index < 0) throw new IndexOutOfBoundsException();
		
		Node<E> x = head;
		
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	public void addFirst(E o) {
		Node<E> new_node = new Node<>(o);
		
		new_node.next = head;
		head = new_node;
		size++;
		
		/**
		 * 다음에 가리킬 노드가 없는 경우(=데이터가 새 노드밖에 없는 경우)
		 * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
		 * 마지막 노드다. 즉 tail = head 다.
		 */
		if (head.next == null) {
			tail = head;
		}
		
	}
	
	public void addLast(E o) {
		Node<E> new_node = new Node<>(o);
		
		if(size == 0) {
			addFirst(o);
			return;
		}
		
		tail.next = new_node;
		tail = new_node;
		
	}
	
	@Override
	public boolean add(E o) {
		addLast(o);
		return true;
	}
	
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
