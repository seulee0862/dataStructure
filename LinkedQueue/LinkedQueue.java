package LinkedQueue;

public class LinkedQueue 
{
	private Node front;
	private Node rear;
	
	public boolean isEmpty()
	{
		return null == front;
	}
	
	public void add(Object data)
	{
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty())
		{
			front = rear = newNode;
		}
		else
		{
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public Object poll()
	{
		if(isEmpty())
		{
			return null;
		}
		
		Node removeNode = front;
		Object tempData = front.data;
		front = front.next;
		
		removeNode = null;
		if(removeNode == rear)
		{
			rear = null;
		}
		
		return tempData;
	}
	
	public Object peek()
	{
		if(isEmpty())
		{
			return null;
		}
		return front.data;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		Node cursor = front;
		builder.append("front").append("->");
		while(null != cursor)
		{
			builder.append(cursor.data).append("->");
			cursor = cursor.next;
		}
		builder.append("rear");
		
		return builder.toString();
	}
}
