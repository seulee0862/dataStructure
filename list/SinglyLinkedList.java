package list;


public class SinglyLinkedList {
	
	Node head = null;
	int size = 0;
	
	private Node findNode(int searchIndex)
	{
		if(0 > searchIndex || size <= searchIndex)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int nodeIndex = 0;
		
		Node pointer = head;
		while(nodeIndex != searchIndex)
		{
			pointer = pointer.next;
			nodeIndex++;
		}
		return pointer;
	}
	
	public Object getData(int searchIndex)
	{
		return findNode(searchIndex).data;
	}
	
	public boolean isEmpty()
	{
		return 0 == size;
	}
	
	public int size() 
	{
		return size;
	}
	
	public void addLast(Object data)
	{
		add(size,data);
	}
	
	public void addFirst(Object data)
	{
		add(0,data);
	}
	
	public void removeLast()
	{
		remove(size-1);
	}
	
	public void removeFirst()
	{
		remove(0);
	}
	
	public void autoAdd(Object data)
	{
		Node node = new Node();
		node.data = data;
		
		while(true)
		{
			if(head.next == null)
			{
				head.next = node;
				break;
			}
		}
		size++;
	}
	
	
	public void add(int index, Object data)
	{
		Node node = new Node();
		node.data = data;
		
		if( 0 == index)
		{
			node.next = head;
			head = node;
		}else
		{
			Node foundNode = findNode(index-1);
			node.next = foundNode.next;
			foundNode.next = node;
		}
		size++;
	}
	
	public void remove(int index)
	{
		if( 0 == index && null != head)
		{
			head = head.next;
		}
		else
		{
			Node prevNode = findNode(index-1);
			prevNode.next = prevNode.next.next;
		}
	}
	
	public String get(int index)
	{
		String value = (String)findNode(index).data;
		return value;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder stringBuilder = new StringBuilder();
		Node pointer = head;
		stringBuilder.append("head").append("->");
		while( null != pointer)
		{
			stringBuilder.append(pointer.data).append("->");
			pointer = pointer.next;
		}
		stringBuilder.append("null");
		return stringBuilder.toString();
	}
	
}
