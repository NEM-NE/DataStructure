package Interface;
/*
 * 
[공통점]
1. 동일한 특성의 데이터들을 묶는다.
2. 반복문(loop)내에 변수를 이용하여 하나의 묶음 데이터들을 모두 접근할 수 있다.

 
[차이점 - 배열]
1. 처음 선언한 배열의 크기(길이)는 변경할 수 없다. 이를 정적 할당(static allocation)이라고 한다.
2. 메모리에 연속적으로 나열되어 할당된다.
3. index에 위치한 하나의 데이터(element)를 삭제하더라도 해당 index에는 빈공간으로 계속 남는다. 


[차이점 - 리스트]
1. 리스트의 길이가 가변적이다. 이를 동적 할당(dynamic allocation)이라고 한다.
2. 데이터들이 연속적으로 나열된다. (메모리에 연속적으로 나열되지 않고 각 데이터들은 주소(reference)로 연결되어있다. C에서의 포인터라고 생각하면 된다.)
3. 데이터(element) 사이에 빈 공간을 허용하지 않는다.



[배열의 장단점]

<장점>
1. 데이터 크기가 정해져있을 경우 메모리 관리가 편하다.
2. 메모리에 연속적으로 나열되어 할당하기 때문에 index를 통한 색인(접근)속도가 빠르다.

<단점>
1. 배열의 크기를 변경할 수 없기 때문에 초기에 너무 큰 크기로 설정해주었을 경우 메모리 낭비가 심해지고, 반대로 너무 작은 크기로 설정해주었을 경우 데이터를 다 못담을 수 있는 경우가 발생 할 수 있다.
2. 빈 공간을 허용하지 않고 데이터를 삽입(add), 삭제(remove)를 하고자 한다면, 뒤의 데이터들을 모두 밀어내거나 당여주어야 하기 때문에 속도가 느려 삽입, 삭제가 빈번한 경우에는 유용하지 않다.

 
[리스트의 장단점]

<장점>
1. 데이터의 개수에 따라 해당 개수만큼 메모리를 동적 할당해주기 때문에 메모리 관리가 편리해진다.
2. 빈 공간을 허용하지 않기 때문에 데이터 관리에도 편하다.
3. 포인터(주소)로 각 데이터들이 연결되어 있기 때문에 해당 데이터에 연결된 주소만 바꿔주면 되기 때문에 삽입 삭제에 용이하다.(ArrayList는 예외)

<단점>
1. 객체로 데이터를 다루기 때문에 적은양의 데이터만 쓸 경우 배열에 비해 차지하는 메모리가 커진다.
2. 기본적으로 주소를 기반으로 구성되어있고 메모리에 순차적으로 할당하는 것이 아니기 때문에(물리적 주소가 순차적이지 않다) 색인(검색)능력은 떨어진다.

 */

public interface List<E> extends Collection<E>, Iterable<E>{
	
	/**
	 * 리스트에 요소를 특정 위치에 추가합니다. 
	 * 특정 위치 및 이후의 요소들은 한 칸씩 뒤로 밀립니다.
	 * 
	 * @param index 리스트에 요소를 추가할 특정 위치 변수
	 * @param element 리스트에 추가할 요소
	 */
	void add(int index, Object element);
	
	/**
	 * 리스트에 지정된 컬랙션에 포함된 객체를 특정 위치에 추가합니다. 
	 * 특정 위치 및 이후의 요소들은 한 칸씩 뒤로 밀립니다.
	 * 
	 * @param index 리스트에 요소를 추가할 특정 위치 변수
	 * @param c 리스트에 추가할 컬랙션
	 * @return 해당 컬렉션에  지정된 컬랙션에 포함된 객체가 추가됐을 경우  {@code true}를 반환하고
	 *         아닐 경우 {@code false}를 반환
	 */
	boolean addAll(int index, Collection<? extends E> c);
	
	/**
	 * 리스트에 지정된 특정 위치에 있는 객체를 찾아 반환
	 * 
	 * @param index 리스트에 요소를 추가할 특정 위치 변수
	 * @throws IndexOutOfBoundsException
	 */
	E get(int index);
	
	/**
	 * 지정된 객체가 리스트 내에 몇 번째 위치에 있는지 인덱스로 반환
	 * 
	 * @param o 리스트에서 찾을 특정 변수
	 * @return 찾을 경우 해당 인덱스를 반환
	 * 못 찾을 경우 -1 반환
	 * @throws NullPointerException
	 * @throws ClassCastException
	 */
	int indexOf(Object o);
	
	/**
	 * 지정된 객체가 리스트 내에 몇 번째 위치에 있는지 인덱스로 반환
	 * 단, 역순으로 탐색
	 * 
	 * @param o 리스트에서 찾을 특정 변수
	 * @return 찾을 경우 해당 인덱스를 반환
	 * 못 찾을 경우 -1 반환
	 * @throws NullPointerException
	 * @throws ClassCastException
	 */
	int lastIndexOf(Object o);
	
	/**
	 * 리스트에 지정된 특정 위치에 있는 객체를 리스트에서 제거
	 * 
	 * @param index 리스트에 요소를 제거할 특정 위치 변수
	 */
	E remove(int index);
	
	/**
	 * 리스트에 지정된 특정 위치에 있는 객체를 지정된 객체로 변경
	 * 
	 * @param index 리스트에 요소를 제거할 특정 위치 변수
	 * @param element 특정 위치에 있는 요소와 변경할 특정 객체 변수
	 */
	E set(int index, Object element);
	
	
	/**
	 * fromIndex부터 toIndex까지 리스트 내에 있는 객체들을 리스트 형식으로 반환 (fromIndex <= 범위 <= toIndex)
	 * 
	 * @param fromIndex 리스트에서 찾을 특정 변수
	 * @param toIndex 리스트에서 찾을 특정 변수
	 * @return 지정된 범위 내에 있는  리스트를 반환
	 * 단, 범위가 0일 경우 빈 리스트로 반환
	 */
	List<E> subList(int fromIndex, int toIndex);
}
