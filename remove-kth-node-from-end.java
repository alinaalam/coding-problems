/**
 * https://www.udemy.com/course/data-structure-and-algorithms-analysis/learn/lecture/19398522#questions
 * @author alinaalam
 * Uses my own implementation of Linked List class https://github.com/alinaalam/coding-problems/blob/master/linked-list.java
 */
public class RemoveKthNodeFromEnd {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		fillUpLinkedList(list);
		
		list.display();
		
		LinkedList<Integer>.Node<Integer> head = list.getHead();
		
		head = removeKthNodeFromEnd(head, 5);
		list.setHead(head);
		
		System.out.println("After deleting the middle element");
		list.display();
		
		
		head = removeKthNodeFromEnd(head, 1);
		list.setHead(head);
		
		System.out.println("After deleting the end element");
		list.display();
		
		head = removeKthNodeFromEnd(head, 8);
		list.setHead(head);
		
		System.out.println("After deleting the first element");
		list.display();
	}
	
	private static <T> LinkedList<T>.Node<T> removeKthNodeFromEnd(LinkedList<T>.Node<T> head, int k) {
		LinkedList<T>.Node<T> fastPointer = head;
		LinkedList<T>.Node<T> slowPointer = head;
		
		while (k > 0 && fastPointer != null) {
			fastPointer = fastPointer.next;
			k--;
		}
		
		if (k != 0) {
			return head;
		}
		
		LinkedList<T>.Node<T> prev = null;
		
		while (fastPointer != null) {
			prev = slowPointer;
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		
		if (prev == null) {
			head = slowPointer.next;
		}
		else {
			prev.next = slowPointer.next;
		}
		
		return head;
	}
	
	private static void fillUpLinkedList(LinkedList<Integer> list) {
		for (int i = 1; i <= 10; i++) {
			list.addLast(i);
		}
	}
}
