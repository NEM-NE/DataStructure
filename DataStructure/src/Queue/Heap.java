package Queue;

import java.util.Comparator;

public class Heap<E> {

	private final Comparator<? super E> comparator;
	private static final int DEFAULT_CAPACITY = 10; // 최소(기본) 용적 크기
	private int size; // 요소 개수
	private Object[] array; // 요소를 담을 배열
	// 생성자 Type 1 (초기 공간 할당 X)

	public Heap() {
		this(null);
	}

	public Heap(Comparator<? super E> comparator) {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}

	// 생성자 Type 2 (초기 공간 할당 O)
	public Heap(int capacity) {
		this(capacity, null);
	}

	public Heap(int capacity, Comparator<? super E> comparator) {
		this.array = new Object[capacity];
		this.size = 0;
		this.comparator = comparator;
	}

	// 받은 인덱스의 부모 노드 인덱스를 반환
	private int getParent(int index) {
		return index / 2;
	}

	// 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환
	private int getLeftChild(int index) {
		return index * 2;
	}

	// 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
	private int getRightChild(int index) {
		return index * 2 + 1;
	}

	private void resize(int newCapacity) {
		Object[] newArray = new Object[newCapacity];

		System.arraycopy(array, 0, newArray, 0, array.length);

		array = null;
		array = newArray;
	}

	public void add(E value) {
		if (size + 1 == array.length)
			resize(array.length * 2);
		siftUp(size + 1, value);
		size++;

	}

	// 상향 선별
	/**
	 * @param idx    추가할 노드의 인덱스
	 * @param target 재배치 할 노드
	 */
	private void siftUp(int idx, E target) {
		// comparator가 존재할 경우 comparator 을 인자로 넘겨준다.
		if (comparator != null) {
			siftUpComparator(idx, target, comparator);
		} else {
			siftUpComparable(idx, target);
		}
	}

	// Comparator을 이용한 sift-up
	@SuppressWarnings("unchecked")
	private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
		// root노드보다 클 때까지만 탐색한다.
		while (idx > 1) {
			int parent = getParent(idx); // 삽입노드의 부모노드 인덱스 구하기
			Object parentVal = array[parent]; // 부모노드의 값
			// 타겟 노드 값이 부모노드보다 크면 반복문 종료
			if (comp.compare(target, (E) parentVal) >= 0) {
				break;
			}
			/*
			 * 부모노드가 타겟노드보다 크므로 현재 삽입 될 위치에 부모노드 값으로 교체해주고 타겟 노드의 위치를 부모노드의 위치로 변경해준다.
			 */
			array[idx] = parentVal;
			idx = parent;
		}
		// 최종적으로 삽입될 위치에 타겟 노드 값을 저장해준다.
		array[idx] = target;
	}

	// 삽입 할 객체의 Comparable을 이용한 sift-up
	@SuppressWarnings("unchecked")
	private void siftUpComparable(int idx, E target) {
		// 타겟노드가 비교 될 수 있도록 한 변수를 만든다.
		Comparable<? super E> comp = (Comparable<? super E>) target;
		while (idx > 1) {
			int parent = getParent(idx);
			Object parentVal = array[parent];
			if (comp.compareTo((E) parentVal) >= 0) {
				break;
			}
			array[idx] = parentVal;
			idx = parent;
		}
		array[idx] = comp;
	}

}
