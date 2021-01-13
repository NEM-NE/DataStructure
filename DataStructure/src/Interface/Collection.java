package Interface;

public interface Collection<E> extends Iterable<E> {
	/**
	 * 지정된 객체 및 컬랙션의 객체들을 컬랙션에 추가
	 * 
	 * @param o 지정된 객체, c 지정된 컬랙션
	 * @return 성공적으로 컬랙션에 넣으면  {@code true}를 반환하고
	 *         못넣었을 경우 {@code false}를 반환
	 */
	boolean add(E o);
	boolean addAll(Collection<? extends E> c); //  <? extends E>의미는 E와 E의 자손들을 가르킴
	
	/**
	 * 지정된 객체 및 컬랙션의 객체 내부를 다 비우기
	 * 
	 */
	void clear();
	
	/**
	 * 지정된 객체 및 컬랙션의 객체가 컬랙션 내부에 포함되어 있느지 검사
	 * 
	 * @param o 지정된 객체, c 지정된 컬랙션
	 * @return 컬랙션 내부에 지정된 객체 및 컬랙션이 있다면  {@code true}를 반환하고
	 *         없는 경우 {@code false}를 반환
	 */
	boolean contains(Object o);
	boolean containsAll(Collection<?> c); // <?> all
	
	/**
	 * 지정된 컬랙션이 해당 컬랙션과 같은지 비교
	 * 
	 * @param o 지정된 객체(컬랙션)
	 * @return 지정된 객체와 해당 컬렉션이 같을 경우  {@code true}를 반환하고
	 *         아닐 경우 {@code false}를 반환
	 */
	boolean equals(Object o);
	
	/**
	 * 해당 컬렉션의 메모리 주소를 해쉬로 변환
	 * 
	 * @return 해당 컬렉션의 해쉬를 반환
	 */
	int hashCode();
	
	/**
	 * 해당 컬렉션 내부가 비어있는지 검사
	 * 
	 * @return 해당 컬렉션의 내부가 비어있을 경우  {@code true}를 반환하고
	 *         아닐 경우 {@code false}를 반환
	 */
	boolean isEmpty();
	
	/**
	 * 
	 * @return 해당 컬렉션의 iterator를 얻어 반환
	 */
	Iterator<E> iterator();
	
	/**
	 * 해당 컬랙션에 지정된 객체를 삭제하거나 해당 컬렉션 내용을 다 지운다.
	 * 
	 * @param o 지정된 객체, c 지정된 컬랙션
	 * @return 지정된 객체 및 컬랙션이 삭제됐을 경우 {@code true}를 반환하고
	 *         아닐 경우 {@code false}를 반환
	 */
	boolean remove(Object o);
	boolean removeAll(Collection<?> c);
	
	/**
	 * 지정된 컬랙션만 남기고 나머지 객체들은 해당 컬랙션에서 제거 한다.
	 * 
	 * @param c 지정된 컬랙션
	 * @return 해당 컬랙션이 변화가 있을 경우 {@code true}를 반환하고
	 *         아닐 경우 {@code false}를 반환
	 */
	boolean retainAll(Collection<?> c);
	
	/**
	 * 
	 * @return 해당 컬렉션의 크기를 반환
	 */
	int size();
	
	/**
	 * 해당 컬랙션을 배열로 반환
	 * 
	 * @return 해당 컬랙션에 저장된 객체를 객체배열로 반환
	 */
	Object[] toArray();
	
	/**
	 * 해당 컬랙션을 배열로 반환
	 * 
	 * @param  a 지정된 타입 배열
	 * @return 지정된 배열에 해당 컬랙션의 객체를 저장해서 반환
	 */
	<T> T[] toArray(T[] a);
}
