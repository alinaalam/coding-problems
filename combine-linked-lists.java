/**
 * https://www.udemy.com/course/data-structure-and-algorithms-analysis/learn/lecture/6293400#questions
 * @author alinaalam
 * Uses my own implementation of Linked List class https://github.com/alinaalam/coding-problems/blob/master/linked-list.java
 */
public class CombineLinkedLists {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		
		fillUpLinkedList(list1);
		
		fillUpLinkedList(list2);
		
		combineLinkedLists(list1.getHead(), list2.getHead());
		
		list1.display();
	}
	
	public static <T> void combineLinkedLists(LinkedList<T>.Node<T> head1, LinkedList<T>.Node<T> head2) {
		LinkedList<T>.Node<T> temp = head2;
		
		LinkedList<T> stack = new LinkedList<>();
		
		while (temp != null) {
			stack.addFirst(temp.value);
			temp = temp.next;
		}
		
		temp = head1;
		
		while (temp != null && !stack.isEmpty()) {
			LinkedList<T>.Node<T> reverseNode = stack.new Node<T>(stack.getFirst());
			stack.deleteFirst();
			reverseNode.next = temp.next;
			temp.next = reverseNode;
			temp = reverseNode.next;
		}
		
	}
	
	private static void fillUpLinkedList(LinkedList<Integer> list) {
		for (int i = 1; i <= 5; i++) {
			list.addLast(i);
		}
	}
}
