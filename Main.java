import ArrayStack.ArrayStack;
import CircleQueue.CircleQueue;
import DoublyLinkedList.DoublyLinkedList;

public class Main
{
	public static void main(String[] args) 
	{
		CircleQueue circleQueue = new CircleQueue(3);
		circleQueue.add(1);
		System.out.println(circleQueue.poll());
		circleQueue.add(3);
		System.out.println(circleQueue.peek());
		System.out.println(circleQueue.poll());
		System.out.println(circleQueue.peek());
		circleQueue.add(1);
		circleQueue.add(2);
		circleQueue.add(3);
		circleQueue.add(4);
		circleQueue.add(5);
		circleQueue.add(6);
		
		System.out.println(circleQueue.toString());
	}
}
