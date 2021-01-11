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
	
	
	void clear();
	boolean contains(Object o);
	boolean containsAll(Collection<?> c); // <?> all
	boolean equals(Object o);
	int hashCode();
	boolean isEmpty();
	Iterator<E> iterator();
	boolean remove(Object o);
	boolean removeAll(Collection<?> c);
	boolean retainAll(Collection<?> c);
	int size();
	Object[] toArray();
	<T> T[] toArray(T[] a);
}
