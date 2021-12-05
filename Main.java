import ArrayStack.ArrayStack;
import DoublyLinkedList.DoublyLinkedList;

public class Main
{
	public static void main(String[] args) 
	{
		ArrayStack arrayStack = new ArrayStack(4);
		System.out.println(arrayStack.isEmpty());
		arrayStack.push("C");
		arrayStack.push("B");
		System.out.println(arrayStack.peek());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.toString());
		System.out.println(arrayStack);
	}
}
