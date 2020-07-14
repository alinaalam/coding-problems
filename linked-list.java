
public class LinkedList<T> {
	
	Node<T> head;
	
	public class Node<T> {
		T value;
		Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	public void addFirst(T value) {
		Node<T> newNode = new Node<>(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void addLast(T value) {
		if (head == null) {
			addFirst(value);
			return;
		}
		
		Node<T> newNode = new Node<T>(value);
		Node<T> curr = head;
		
		while (curr.next != null) {
			curr = curr.next;
		}
		
		// curr is basically the last node now
		curr.next = newNode;
	}
	
	public void deleteFirst() {
		if (head != null) {
			head = head.next;
		}
	}
	
	public T getFirst() {
		T value = null;
		if (head != null) {
			value = head.value;
		}
		
		return value;
	}
	
	public void deleteLast() {
		if (head != null) {
			Node<T> prev = null;
			Node<T> curr = head;
			
			while (curr.next != null) {
				prev = curr;
				curr = curr.next;
			}
			
			// prev is basically the 2nd last node now
			if (prev != null) {
				prev.next = null;
			}  
		}
	}
	
	public void display() {
		Node<T> curr = head;
		while (curr != null) {
			System.out.println(curr.value);
			curr = curr.next;
		}
	}
	
	public Node<T> getHead() {
		return head;
	}
	
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		
		// displays list in descending order
		System.out.println("Displaying list in descending order");
		list.display();
		
		System.out.println("Deleting list using deleteFirst");
		for (int i = 0; i < 4; i++) {
			list.deleteFirst();
			list.display();
		}
		
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		
		//displays list in ascending order
		System.out.println("Displaying list in ascending order");
		list.display();
		
		System.out.println("Deleting list using deleteLast");
		for (int i = 0; i < 4; i++) {
			list.deleteLast();
			list.display();
		}
	}

}
