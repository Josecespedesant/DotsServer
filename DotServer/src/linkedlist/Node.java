package linkedlist;


/**
 * Node class declaration.
 * @author xavier
 * @credits http://codigolibre.weebly.com/blog/listas-simples-en-java
 */
public class Node<T> {
	
	/**
	 * Node class attributes.
	 */
	private T value;
	private Node<T> next;
	
	/**
	 * Node class constructor 1.
	 * There aren't more nodes.
	 */
	public Node() {
		this.value = null;
		this.next = null;
	}
	
	/**
	 * Node class constructor 2.
	 * There's more than one node.
	 * @param value
	 * @param next
	 * @param prev
	 */
	public Node(T value, Node<T> next, Node<T> prev) {
		this.value = value;
		this.next = next;
	}
	
	/**
	 * Getter of the attribute value.
	 * @return value
	 */
	public T getData() {
		return value;
	}
	
	/**
	 * Setter of the attribute value.
	 * @param value
	 */
	public void setData(T value) {
		this.value = value;
	}
	
	/**
	 * Getter of the attribute next.
	 * @return next
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * Setter of the attribute next.
	 * @param node
	 */
	public void setNext(Node<T> node) {
		this.next = node;
	}
	
	

}
