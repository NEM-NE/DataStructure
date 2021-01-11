package Interface;

public interface Iterator<E> {
	
	/**
	 * Iteration이 요소를 가지고 있는지 확인합니다.
	 * 요소 확인 후 다시 호출 될 경우 그 다음 요소가 있는지 확인합니다.
	 * 
	 * @return Iteration이 요소를 가지고 있을 경우  {@code true}를 반환하고
	 *         없을 경우 {@code false}를 반환
	 */
	boolean hasNext();
	
	/**
	 * Iteration에 있는 다음 요소를 읽습니다.
	 * 
	 * @param value 리스트에 추가할 요소
	 * @throws 만약 Iteration에 더 이상 요소가 없을 경우 NoSuchElementException 발생.
	 * @return Iteration에 있는 요소를 반환  다시 호출 될 경우 그 다음 요소를 반환
	 */
	E next();
	
	/**
	 * 
	 * 
	 * 
	 * @throws
	 * @throws
	 */
	void remove();
}
