import java.util.NoSuchElementException;

public class ListOfNodes<P> {
	public int size;
	private class Node{
		public P item;
		Node next;
		public Task taskItem;
		
		public Node(P item, Task t) {
			this.item = item;
			this.taskItem = t;
			this.next = null;
		}
	}
	
	private Node head = null;
	private Node tail= null;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int Size() {
		return size;
	}
	
	public void insert(P item, Task t) {
		Node newNode = new Node(item, t);
		if(head == null) {       
            head = newNode;    
            tail = newNode;    
        }    
        else {        
            tail.next = newNode;        
            tail = newNode;    
        } 
		size++;
		((Processor) item).add(t);
	}
	
	public P peek_item() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.item;
	}
	
	public Task peek_task_item() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.taskItem;
	}
	
	public P get() throws NoSuchElementException{
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		P result = head.item;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return result;
	}

//	public void add(Task t) {
//		// TODO Auto-generated method stub
//		
//	}

}
