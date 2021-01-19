package List;

import java.util.NoSuchElementException;

import Interface.Collection;
import Interface.Iterator;
import Interface.List;

public class SLinkedList<E> implements List<E> {
	private SNode<E> head;	// 노드의 첫 부분 
	private SNode<E> tail;	// 노드의 마지막 부분
	private int size;	// 요소 개수 
	
	// 생성자
	public SLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	private SNode<E> search(int index){
		if(index >= size || index < 0) throw new IndexOutOfBoundsException();
		
		SNode<E> x = head;
		
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	public void addFirst(E o) {
		SNode<E> new_node = new SNode<>(o);
		
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
		SNode<E> new_node = new SNode<>(o);
		
		if(size == 0) {
			addFirst(o);
			return;
		}
		
		tail.next = new_node;
		tail = new_node;
		size++;
		
	}
	
	@Override
	public boolean add(E o) {
		addLast(o);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, Object element) {
		if(index >= size || index < 0) throw new IndexOutOfBoundsException();
		SNode<E> new_node = new SNode<E>((E) element);
		
 		if(index == 0){
			addFirst((E) element);
			return;
		}
		if(index == size-1) {
			addLast((E) element);
			return;
		}
		
		SNode<E> pre_node = search(index-1);
		SNode<E> current_node = search(index-1);
		pre_node.next = new_node;
		new_node.next = current_node;
		
		size++;
		
	}
	
	public E remove() {// remove head
		SNode<E> temp = head;
		
		if(temp == null) throw new NoSuchElementException();
		
		head = head.next;
		E result = temp.data;
		
		temp.next = null;
		temp.data = null;
		
		size--;
		
		return result;
	}
	
	@Override
	public E remove(int index) {
		if(index >= size || index < 0) throw new IndexOutOfBoundsException();
		
		if(index == 0) {
			return remove();
		}
		
		SNode<E> pre_node = search(index-1);
		SNode<E> current_node = pre_node.next;
		SNode<E> next_node = current_node.next;
		
		pre_node.next = next_node;

		E result = current_node.data;
		current_node.data = null;
		current_node.next = null;
		
		size--;
		
		return result;
	}
	
	@Override
	public boolean remove(Object o) {
		SNode<E> pre_node = head;
		SNode<E> x = head;
		boolean hasValue = false;
		
		for(; x != null; x = x.next) {
			if(o.equals(x.data)) {
				hasValue = true;
				break;
			}
			pre_node = x;
		}
		
		if(x.equals(head)) {
			remove();
			return true;
		}
		
		else if(!hasValue) {
			return hasValue;
		}
		
		else {
			SNode<E> current_node = pre_node.next;
			SNode<E> next_node = current_node.next;
			
			pre_node.next = next_node;

			current_node.data = null;
			current_node.next = null;
			
			size--;
			return true;
		}
	}
	
	@Override
	public E get(int index) {
		return search(index).data;
	}

	@Override
	public int indexOf(Object o) {
		int cnt = 1;
		SNode<E> pre_node = head;
		
		for(; cnt < size; cnt++ ) {
			if(pre_node.data.equals(o)) {
				return cnt;
			}
			pre_node = pre_node.next;
		}
		
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, Object element) {
		SNode<E> node = search(index);
		node.data = (E) element;
		return null;
	}
	
	@Override
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		SNode<E> x = head;
		
		for(; x != null;) {
			SNode<E> next = x.next;
			x.data = null;
			x.next = null;
			
			x = next;
		}
		
		head = tail = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() > 0;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
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
