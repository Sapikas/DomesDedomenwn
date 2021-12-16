import java.util.NoSuchElementException;

//import IntQueueImpl.Node;

public class List<T> {
	public int time;
	public int size;
	
	private class Node{
		public T item;
		Node next;
		private int time;
		
		public Node(T item) {
			this.item = item;
			//this.time = ((Task) item).getTime();
			this.next = null;
		}
	}
	
	private Node head = null;
	private Node tail= null;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(T item) {
		Node newNode = new Node(item);
		if(head == null) {       
            head = newNode;    
            tail = newNode;    
        }    
        else {        
            tail.next = newNode;        
            tail = newNode;    
        } 
		size++;
		//this.time += ((Task) item).getTime();
		time += ((Task) item).getTime();
	}
	
	public int get() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T result = head.item;
		int Time = ((Task) result).getTime();
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return Time;
		
	}
	
	public int getTime() {
		return time;
	}
}
