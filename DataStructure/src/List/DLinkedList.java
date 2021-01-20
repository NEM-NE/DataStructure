package List;

import java.util.NoSuchElementException;

import Interface.Collection;
import Interface.Iterator;
import Interface.List;

public class DLinkedList<E> implements List<E>, Collection<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public DLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	private Node<E> search(int index){
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		if(index > size/2) {	// tail first search
			Node<E> node = tail;
			for(int i = size-1; i >= index; i--) {
				node = node.pre;
			}
			
			return node;
		}else {		//head first search
			Node<E> node = head;
			for(int i = 0; i <= index; i++) {
				node = node.next;
			}
			
			return node;
		}
		
	}
	
	public void addFirst(E o) {
		Node<E> new_node = new Node<>(o);
		new_node.next = head;
		
		if(head != null) {
			head.pre = new_node;
		}
	
		head = new_node;
		size++;
		
		if(head.next == null) {
			tail = head;
		}
	}
	
	@Override
	public boolean add(E o) {	//addLast
		Node<E> new_node = new Node<>(o);
		
		if(size == 0) {
			addFirst(o);
			return true;
		}
		
		new_node.pre = tail;
		tail.next = new_node;
		tail = new_node;
		
		size++;
		
		return true;
	}
	
	@Override
	public void add(int index, Object element) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		if(index == 0) addFirst((E) element);
		if(index == size) add((E) element);
		
		Node<E> current_node = search(index);	
		Node<E> pre_node = current_node.pre;
		Node<E> new_node = new Node<>((E) element);
		
		new_node.pre = pre_node;
		new_node.next = current_node;
		
		current_node.pre = new_node;
		pre_node.next = new_node;
		
		size++;
	}	
	
	public E remove() {
		Node<E> temp = head;
		E element = head.data;
		
		if(temp == null) throw new NoSuchElementException();
		
		head = head.next;
		head.pre = null;
		
		temp.data = null;
		temp.next = null;
		
		size--;
		
		if(size == 0) tail = null;
		
		return element;
	}
	
	@Override
	public boolean remove(Object o) {
		Node<E> x = head;
		Node<E> pre_node = x;
		boolean hasValue = false;
		
		for(; x != null; x = x.next) {
			if(x.data.equals(o)) {
				hasValue = true;
				break;
			}
			pre_node = x;
		}
		
		if(x.equals(head)) {
			remove();
			return true;
		}else if(!hasValue) {
			return false;
		}else {
			Node<E> node = pre_node.next;
			Node<E> next_node = node.next;
			
			if(next_node != null ) {
				pre_node.next = next_node;	
				next_node.pre = pre_node;
			}else {
				tail = pre_node;
			}

			node.data = null;
			node.pre = null;
			node.next = null;
			size--;
			return true;
		}
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		if(index == 0) return remove();
		
		Node<E> pre_node = search(index-1);
		Node<E> current_node = pre_node.next;
		Node<E> next_node = current_node.next;
		
		E element = current_node.data;
		
		if(next_node != null) {
			pre_node.next = next_node;
			next_node.pre = pre_node;	
		}else { //if remove tail
			tail = pre_node;
		}
		
		current_node.data = null;
		current_node.pre = null;
	
		return element;
	}
	
	@Override
	public E get(int index) {
		return search(index).data;
	}

	@Override
	public int indexOf(Object o) {		//HEAD FIRST
		Node<E> node = head;
		int cnt = 0;
		
		for(; node != null; node = node.next) {
			if(o.equals(node.data)) {
				return cnt;
			}
			cnt++;
		}
		
		return -1;
	}
	
	@Override
	public int lastIndexOf(Object o) {		//TAIL FRIST
		Node<E> node = tail;
		int cnt = size;
		
		for(; node != null; node = node.pre) {
			cnt--;
			if(o.equals(node.data)) {
				return cnt;
			}
		}
		
		return -1;
	}
	
	@Override
	public E set(int index, Object element) {
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
		
		Node<E> current_node = search(index);
		E ele = current_node.data;
		current_node.data = (E) element;
		
		return ele;
	}
	
	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public void clear() {
		Node<E> node = head;
		
		for(; node != null; node = node.next) {
			node.data = null;
			node.pre = null;
		}
		
		head = tail = null;
		size = 0;
		
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
