package List;

import java.util.Arrays;

import Interface.Collection;
import Interface.Iterator;
import Interface.List;

/*
 * ArrayList는 동적할당을 이용하여 크기를 고정적으로 정한 것이 아닌 크기가 유돟적으로 변경된다.
 * 또한, 다른 리스트와는 다르게  Object[] 배열만을 사용한다.
 * 그리고 데이터가 연속적으로 저장되는 특성이 있어 중간에 데이터가 삭제된다면 뒤에 있는 데이터들을 끌어 온다.
 * 리스트의  실제 크기를 알고 싶으면 capacity를 사용, 그냥 크기를 알고싶으면 size 사용 
 * 
 * 따라서 ArrayList는 그냥 배열 + 기능 + 동적할당을 합친 클래스이다. 그래서 배열의 장점을 가지되 리스트의 장점을 많이 갖지 못하고 있다.
 */

public class ArrayList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] DEFALUT_EMPTY_ARRAY = {};
	
	private int size;
	private int capacity;
	
	Object[] array;
	
	
	public ArrayList() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
	
	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
	}
	
	private void resize() {
		
		// if array capacity 0
		if(Arrays.equals(array, DEFALUT_EMPTY_ARRAY)) {
			array = new Object[DEFAULT_CAPACITY];
			return;
		}
		//if array capacity full
		else if(this.size == this.capacity) {
			int new_capacity = this.capacity * 2;
			this.capacity = new_capacity;
			
			Object[] temp = new Object[this.capacity];
			System.arraycopy(temp, 0, array, 0, this.size);
			array = temp;
			return;
		}
		//if array capacity under half
		else if(this.size <= this.capacity/2) {
			int new_capacity = this.capacity / 2;
			this.capacity = new_capacity;
			
			Object[] temp = new Object[this.capacity];
			System.arraycopy(temp, 0, array, 0, this.size);
			array = temp;
			return;
		}
	}
	
	@Override
	public boolean add(E o) {
		
		if(this.size == this.capacity) resize();
		
		array[this.size] = o;
		this.size++;

		return true;
	}

	@Override
	public void add(int index, Object element) {
		if(index > this.capacity || index < 0) throw new IndexOutOfBoundsException();
		if(index == size) array[index] = element;
		else {
			if(this.size == this.capacity) resize();
			
			for(int i  = index+1; i < this.size; i++) {
				array[i] = array[i-1];
			}
			
			array[index] = element;
			this.size++;
		}
		
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index > this.capacity || index < 0) throw new IndexOutOfBoundsException();
		return (E) array[index];
	}

	@Override
	public int indexOf(Object o) {
		for(int i = 0; i < this.size; i++) {
			if(array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		for(int i = this.size-1; i > -1; i++) {
			if(array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, Object element) {
		if(index > this.capacity || index < 0) throw new IndexOutOfBoundsException();
		
		E pre = (E) array[index];
		array[index] = element;
		
		return pre;
	}
	
	@Override
	public boolean contains(Object o) {
		if(indexOf(o) != -1) return true;
		else return false;
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(index > this.capacity || index < 0) throw new IndexOutOfBoundsException();
		
		E element = (E) array[index];	// 삭제될 요소를 반환하기 위해 임시로 담아둠
		array[index] = null;
	    
		// 삭제한 요소의 뒤에 있는 모든 요소들을 한 칸씩 당겨옴
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
			array[i + 1] = null;
		}
		size--;
		resize();
		return element;
	}
	
	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		
		if(index == -1) return false;
		else {
			remove(index);
			return true;
		}
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	@Override
	public void clear() {
		// 모든 공간을 null 처리 해준다. 
		for (int i = 0; i < this.size; i++) {
			array[i] = null;
		}
		this.size = 0;
		resize();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
	}

}
