package DoublyLinkedList;

public class DoublyLinkedList 
{
	Node head = null;
	Node tail = null;
	int size = 0;
	
	private Node findNode(int searchIndex)
	{
		if(0>searchIndex || size <= searchIndex)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int nodeIndex;
		Node pointer;
		
		if(size/2 > searchIndex)
		{
			nodeIndex = 0;
			pointer = head;
			while(nodeIndex != searchIndex)
			{
				nodeIndex++;
				pointer = pointer.right;
			}
		}
		else
		{
			nodeIndex = size-1;
			pointer = tail;
			while(nodeIndex != searchIndex)
			{
				nodeIndex--;
				pointer = pointer.left;
			}
		}
		return pointer;
	}
	
	public Object getData(int searchIndex)
	{
		return findNode(searchIndex).data;
	}
	
	//비어있는 리스트인지 확인
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
	
	public void add(int index,Object data)
	{
		Node node = new Node();
		node.data = data;
		
		if( 0 == index || size == index)
		{
			if(null == this.head && null == this.tail)
			{
				this.head = node;
				this.tail = node;
			}
			else if(0 == index)
			{
				node.right = this.head;
				this.head.left = node;
				this.head = node;
			}
			else
			{
				node.left = this.tail;
				this.tail.right = node;
				this.tail = node;
			}
		}
		else
		{
			Node foundNode = findNode(index);
			Node leftNode = foundNode.left;
		
			node.right = foundNode;
			foundNode.left = node;
			
			node.left = leftNode;
			leftNode.right = node;
		}
		size++;
	}
	
	public void remove(int index)
	{
		Node removeNode = findNode(index);
		Node leftNode = removeNode.left;
		Node rightNode = removeNode.right;
		
		if(null != leftNode)
		{
			leftNode.right = rightNode;
		}
		if(null != rightNode)
		{
			rightNode.left = leftNode;
		}
		if(0 == index)
		{
			this.head = rightNode;
		}
		if(size-1 == index)
		{
			this.tail = leftNode;
		}
		
		removeNode.left = null;
		removeNode.right = null;
		removeNode.data = null;
		
		size--;
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		Node pointer = head;
		stringBuilder.append("head").append("->");
		while(null != pointer)
		{
			stringBuilder.append(pointer.data).append("->");
			pointer = pointer.right;
			
		}
		stringBuilder.append("null");
		if(null != tail)
		{
			stringBuilder.append(",tail(").append(tail.data).append("),");
		}
		pointer = tail;
		stringBuilder.append("tail").append("->");
		while(pointer != null)
		{
			stringBuilder.append(pointer.data).append("->");
			pointer = pointer.left;
		}
		stringBuilder.append("null");
		if(null != head)
		{
			stringBuilder.append(",head(").append(head.data).append(")");
		}
		return stringBuilder.toString();
	}
	
}
