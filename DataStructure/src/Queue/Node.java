package Queue;

public class Node<E> {
	Node<E> next;
	Node<E> pre;
	E data;
	
	public Node(E data) {
		this.data = data;
		this.next = null;
		this.pre = null;
	}
	
}

