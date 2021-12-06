package LinkedStack;

public class LinkedStack 
{
	private Node head;
	
	public boolean isEmpty()
	{
		return null == head;
	}
	
	public void push(Object data)
	{
		Node node = new Node();
		node.data = data;
		
		if(!isEmpty())
		{
			node.next = head;
		}
		head = node;
	}
	
	public Object pop()
	{
		if(isEmpty())
		{
			throw new RuntimeException("stack is empty");
		}
		
		Node removeNode = head;
		Object tempData = removeNode.data;
		head = removeNode.next;
		
		removeNode = null;
		removeNode.next = null;
		
		return tempData;
	}
	
	public Object peek()
	{
		if(isEmpty())
		{
			return null;
		}
		return head.data;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		if(isEmpty())
		{
			return "Empty Stack";
		}
		builder.append("top").append("->");
		while(head.next != null)
		{
			builder.append(head.next).append("->");
			head = head.next;
		}
		builder.append("bottom");
		
		return builder.toString();
	}
}
