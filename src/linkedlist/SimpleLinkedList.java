package linkedlist;

/**
 * SimpleLinkedList class declaration.
 * @author José Antonio Céspedes Downing
 */
public class SimpleLinkedList<T>{
	
	/**
	 * SimpleLinkedList class attributes.
	 */
	private SimpleNode<T> first;
	private int len;
	
	/**
	 * SimpleLinkedList constructor declaration.
	 */
	public SimpleLinkedList() {
		first = null;
		len = 0;
	}
	
	/**
	 * Method that let you know if the list is empty or not.
	 * @return True or False.
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Method that gives you the length of the list.
	 * @return Length of the list.
	 */
	public int getLength() {
		return len;
	}
	
	/**
	 * Method that inserts a new Data at the front of the list.
	 * @param Data
	 */
	public void addFront(T Data) {
		SimpleNode<T> newNode = new SimpleNode<T>();
		newNode.setData(Data);
		
		if(isEmpty()) {
			first = newNode;
		}
		else {
			newNode.setNext(first);
			first = newNode;
		}
		len++;
	}
	
	/**
	 * Method that deletes the item at the front.
	 */
	public void deleteFront() {
		if(isEmpty()) {
			first = null;
		}else {
			first = first.getNext();
		}
		len--;
	}
	
	/**
	 * Method that inserts a new Data at the end of the list.
	 * @param Data
	 */
	public void addLast(T Data) {
		SimpleNode<T> newNode = new SimpleNode<T>();
		newNode.setData(Data);
		if(isEmpty()) {
			first = newNode;
		}
		else {
			SimpleNode<T> aux = new SimpleNode<T>();
			aux = first;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(newNode);
		}
		len++;
	}
	
	/**
	 * Method that delete the last Data at the end of the list.
	 */
	public void deleteLast() {
		SimpleNode<T> aux = new SimpleNode<T>();
		aux = first;
		if(isEmpty() || len == 1 ) {
			first = null;
		}
		else {
			while(aux.getNext().getNext()!=null){
				aux = aux.getNext();
			}
		aux.setNext(null);
		}
		len--;
	}
	
	/**
	 * Method that deletes an object from the list by specifying it.
	 * @param t
	 */
	public void deleteByElement(T t) {
		SimpleNode<T> aux = new SimpleNode<T>();
		
		aux = first;
		if(isEmpty()) {
			first = null;
		}
		else if(first.getData()==t){
			deleteFront();
		}
		else {
			if(aux.getNext() == null) {
				aux = aux.getNext();
			}
			while(aux.getNext()!=null) {
				if(aux.getNext().getData()==t){
					aux.setNext(aux.getNext().getNext());
				}
				else {
					aux = aux.getNext();
				}
			}
		}len--;
	}
	
	/**
	 * Method that displays the elements of the list on console.
	 */
	public void printList() {
		SimpleNode<T> aux = first;
		while(aux!= null) {
			System.out.println(aux.getData().toString());
			aux = aux.getNext();
		}
	}
	
	/**
	 * Returns the first element of the list.
	 * @return first
	 */
	public SimpleNode<T> getFirst() {
		return first;
	}
	
	/**
	 * Allows you to get the last item of the list.
	 * @return
	 */
	protected SimpleNode<T> getLast(){
		SimpleNode<T> aux = first;
		while(aux.getNext()!=null) {
		aux = aux.getNext();
		}
		return aux;
	}
	/**
	 * Let you know if the item is on the list.
	 * @param t
	 * @return
	 */
	public boolean contains(T t) {
		SimpleNode<T> aux = first;
		boolean ans = false;
		while(aux!=null) {
			if(aux.getData().equals(t)) {
				ans = true;
			}aux = aux.getNext();
		}return ans;
	}
	
}