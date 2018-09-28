package queue;

import linkedlist.SimpleLinkedList;

/**
 * LinkedQueue class declaration.
 * @author José Antonio Céspedes Downing
 */
public class LinkedQueue<T> {
	
	private SimpleLinkedList<T> list;
	
	/**
	 * PriorityQueue constructor.
	 */
	public LinkedQueue() {
		list = new SimpleLinkedList<T>();
	}
	
	/**
	 * Method that returns the size of the queue.
	 * @return size
	 */
	public int getSize() {
		return list.getLength();
	}
	
	/**
	 * Method that returns if the list is empty or not.
	 * @return True or False
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Method that inserts an element in the queue.
	 * @param value
	 */
	public void enqueue(T value) {
		list.addLast(value);
	}
	
	/**
	 * Method that removes the first item of the queue.
	 */
	public void dequeue() {
		list.deleteFront();
	}
	
	/**
	 * Method that returns the first item of the queue.
	 * @return first
	 */
	public T first() {
		return list.getFirst().getData();
	}
	
	/**
	 * Method that clear the queue.
	 */
	public void clear() {
		while(!list.isEmpty()) {
			dequeue();
		}
	}

}
